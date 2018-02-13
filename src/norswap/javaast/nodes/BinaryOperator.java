package norswap.javaast.nodes;

import norswap.javalexer.tokens.Operator;

/**
 * A binary operator expression.
 */
public final class BinaryOperator implements Expression
{
    // ---------------------------------------------------------------------------------------------

    /**
     * Properties of the binary operator.
     */
    public final OperatorProperties operator;

    // ---------------------------------------------------------------------------------------------

    /**
     * The token representing the operator.
     */
    public final Operator token;

    // ---------------------------------------------------------------------------------------------

    /**
     * Left hand-side of the operator.
     */
    public final Expression left;

    // ---------------------------------------------------------------------------------------------

    /**
     * Right hand-side of the operator.
     */
    public final Expression right;

    // ---------------------------------------------------------------------------------------------

    public BinaryOperator (Operator token, OperatorProperties operator, Expression left, Expression right)
    {
        assert operator.operands == 2;
        this.token = token;
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    // ---------------------------------------------------------------------------------------------

    @Override public boolean equals (Object o)
    {
        if (this == o) return true;
        if (!(o instanceof BinaryOperator)) return false;
        BinaryOperator that = (BinaryOperator) o;
        return left.equals(that.left) && right.equals(that.right) && operator == that.operator;
    }

    // ---------------------------------------------------------------------------------------------

    @Override public int hashCode ()
    {
        int result = left.hashCode();
        result = 31 * result + right.hashCode();
        result = 31 * result + operator.hashCode();
        return result;
    }

    // ---------------------------------------------------------------------------------------------

    @Override public String toString() {
        return "Binary(" + token.name + ")(" + left + ", " + right + ")";
    }

    // ---------------------------------------------------------------------------------------------
}
