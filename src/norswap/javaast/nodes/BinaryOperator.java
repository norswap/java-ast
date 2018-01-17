package norswap.javaast.nodes;

/**
 * A binary operator expression.
 */
public final class BinaryOperator implements Expression
{
    // ---------------------------------------------------------------------------------------------

    /**
     * The binary operator.
     */
    public final Operator operator;

    // ---------------------------------------------------------------------------------------------

    /**
     * The token representing the operator.
     */
    public final norswap.javalexer.tokens.Operator token;

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

    public BinaryOperator (norswap.javalexer.tokens.Operator token,
                           Operator operator, Expression left, Expression right)
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
