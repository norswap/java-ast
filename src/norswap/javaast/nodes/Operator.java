package norswap.javaast.nodes;

import java.util.HashMap;

import static norswap.javaast.nodes.Operator.Associativity.*;

/**
 * Expression operators (unary, binary and ternary) in Java.
 */
public enum Operator
{
    // ---------------------------------------------------------------------------------------------

    POSTFIX_INCREMENT               (14, 1, "++"),
    POSTFIX_DECREMENT               (14, 1, "--"),
    PREFIX_INCREMENT                (13, 1, "++"),
    PREFIX_DECREMENT                (13, 1, "--"),
    UNARY_PLUS                      (13, 1, "+"),
    UNARY_MINUS                     (13, 1, "-"),
    BITWISE_COMPLEMENT              (13, 1, "~"),
    LOGICAL_COMPLEMENT              (13, 1, "!"),
    MULTIPLICATION                  (12, 2, LEFT, "*"),
    DIVISION                        (12, 2, LEFT, "/"),
    REMAINDER                       (12, 2, LEFT, "%"),
    ADDITION                        (11, 2, LEFT, "+"),
    SUBTRACTION                     (11, 2, LEFT, "-"),
    LEFT_SHIFT                      (10, 2, LEFT, "<<"),
    RIGHT_SHIFT                     (10, 2, LEFT, ">>"),
    UNSIGNED_RIGHT_SHIFT            (10, 2, LEFT, ">>>"),
    GREATER                         (9,  2, LEFT, ">"),
    GREATER_OR_EQUAL                (9,  2, LEFT, ">="),
    SMALLER                         (9,  2, LEFT, "<"),
    SMALLER_OR_EQUAL                (9,  2, LEFT, "<="),
    EQUALITY                        (8,  2, LEFT, "=="),
    NOT_EQUALITY                    (8,  2, LEFT, "!="),
    BITWISE_AND                     (7,  2, LEFT, "&"),
    BITWISE_XOR                     (6,  2, LEFT, "^"),
    BITWISE_OR                      (5,  2, LEFT, "|"),
    LOGICAL_AND                     (4,  2, LEFT, "&&"),
    LOGICAL_OR                      (3,  2, LEFT, "||"),
    TERNARY                         (2,  3, RIGHT, "?:"),
    ASSIGNMENT                      (1,  2, RIGHT, "="),
    ADDITION_ASSIGNMENT             (1,  2, RIGHT, "+="),
    SUBTRACTION_ASSIGNMENT          (1,  2, RIGHT, "-="),
    MULTIPLICATION_ASSIGNMENT       (1,  2, RIGHT, "*="),
    DIVISION_ASSIGNMENT             (1,  2, RIGHT, "/="),
    REMAINDER_ASSIGNMENT            (1,  2, RIGHT, "%="),
    BINARY_AND_ASSIGNMENT           (1,  2, RIGHT, "&="),
    BINARY_XOR_ASSIGNMENT           (1,  2, RIGHT, "^="),
    BINARY_OR_ASSIGNMENT            (1,  2, RIGHT, "|="),
    LEFT_SHIFT_ASSIGNMENT           (1,  2, RIGHT, "<<="),
    RIGHT_SHIFT_ASSIGNMENT          (1,  2, RIGHT, ">>="),
    UNSIGNED_RIGHT_SHIFT_ASSIGNMENT (1,  2, RIGHT, ">>>=");

    // ---------------------------------------------------------------------------------------------

    private static HashMap<String, Operator> string2op = new HashMap<>();
    static {
        for (Operator op: Operator.values())
            string2op.put(op.string, op);
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Returns the operator corresponding to the given string representation
     * (e.g. {@code MULTIPLICATION} for "*"). Beware that for "+" and "-", the binary version and
     * returned, and for "++" and "--", the prefix version is returned.
     */
    public static Operator from (String string) {
        return string2op.get(string);
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Associativity determines to which side operators "bind" when they have the same precedence.
     * For instance {@code 1 + 2 + 3} parses to {@code (1 + 2) + 3} because {@code +} is
     * left-associative.
     */
    public enum Associativity
    {
        /** Left associativity for a binary or ternary operator. */
        LEFT,
        /** Right associativity for a binary or ternary operator. */
        RIGHT
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * The precedence of the operator: the higher the precedence, the more "binding" the operator:
     * for instance {@code 1 * 2 + 3 * 4} parses as {@code (1 * 2) + (3 * 4)} because {@code *}
     * has more precedence than {@code +}.
     */
    public final int precedence;

    // ---------------------------------------------------------------------------------------------

    /**
     * The number of operands taken by the operator (1, 2 or 3).
     */
    public final int operands;

    // ---------------------------------------------------------------------------------------------

    /**
     * Associativity determines to which side operators "bind" when they have the same precedence.
     * For instance {@code 1 + 2 + 3} parses to {@code (1 + 2) + 3} because {@code +} is
     * left-associative.
     * <p>
     * If associativity is not applicable (e.g. the operator only has one operand), this field
     * is {@code null}.
     */
    public final Associativity associativity;

    // ---------------------------------------------------------------------------------------------

    /**
     * String representation of the operator (e.g. "<=").
     */
    public final String string;

    // ---------------------------------------------------------------------------------------------

    Operator (int precedence, int operands, String string)
    {
        this.precedence = precedence;
        this.operands = operands;
        this.associativity = null;
        this.string = string;
    }

    // ---------------------------------------------------------------------------------------------

    Operator (int precedence, int operands, Associativity associativity, String string)
    {
        this.precedence = precedence;
        this.operands = operands;
        this.associativity = associativity;
        this.string = string;
    }

    // ---------------------------------------------------------------------------------------------
}

