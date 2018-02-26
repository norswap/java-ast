package norswap.javaast.nodes;

import norswap.utils.multi.MultiHashMap;

import static norswap.javaast.nodes.OperatorProperties.Associativity.*;
import static norswap.javaast.nodes.OperatorProperties.Type.*;

/**
 * Expression operators (unary, binary and ternary) in Java.
 */
public enum OperatorProperties
{
    // ---------------------------------------------------------------------------------------------

    POSTFIX_INCREMENT               (14, 1, POSTFIX, "++"),
    POSTFIX_DECREMENT               (14, 1, POSTFIX, "--"),
    PREFIX_INCREMENT                (13, 1, PREFIX, "++"),
    PREFIX_DECREMENT                (13, 1, PREFIX, "--"),
    UNARY_PLUS                      (13, 1, PREFIX, "+"),
    UNARY_MINUS                     (13, 1, PREFIX, "-"),
    BITWISE_COMPLEMENT              (13, 1, PREFIX, "~"),
    LOGICAL_COMPLEMENT              (13, 1, PREFIX, "!"),
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

    private static MultiHashMap<String, OperatorProperties> string2op = new MultiHashMap<>();
    static {
        for (OperatorProperties props: OperatorProperties.values())
            string2op.add(props.string, props);
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Returns the operators corresponding to the given string representation, or an empty
     * array if no such operator exist.
     */
    public static OperatorProperties[] from (String string) {
        return string2op.get(string).toArray(new OperatorProperties[0]);
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
     * The type of operator: PREFIX, BINARY or POSTFIX.
     */
    public enum Type
    {
        /** An operator with a single right operand. */
        PREFIX,
        /** An operator with a single left operand. */
        POSTFIX,
        /** An operator with a left operand and a right operand. */
        BINARY,
        /** The ternary operator. */
        TERNARY
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
     * Whether the operator is a prefix, binary or postfix operator.
     */
    public final Type type;

    // ---------------------------------------------------------------------------------------------

    /**
     * String representation of the operator (e.g. "<=").
     */
    public final String string;

    // ---------------------------------------------------------------------------------------------

    OperatorProperties (int precedence, int operands, Type type, String string)
    {
        this.precedence = precedence;
        this.operands = operands;
        this.associativity = type == PREFIX ? RIGHT : LEFT;
        this.type = type;
        this.string = string;
    }

    // ---------------------------------------------------------------------------------------------

    OperatorProperties (int precedence, int operands, Associativity associativity, String string)
    {
        this.precedence = precedence;
        this.operands = operands;
        this.associativity = associativity;
        this.type = operands == 2 ? Type.BINARY : Type.TERNARY;
        this.string = string;
    }

    // ---------------------------------------------------------------------------------------------
}

