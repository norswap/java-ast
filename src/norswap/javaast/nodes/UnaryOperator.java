package norswap.javaast.nodes;

/**
 * A unary operator expression.
 */
public final class UnaryOperator implements Expression
{
    // ---------------------------------------------------------------------------------------------

    /**
     * The unary operator.
     */
    public final Operator operator;

    // ---------------------------------------------------------------------------------------------

    /**
     * The token representing the operator.
     */
    public final norswap.javalexer.tokens.Operator token;

    // ---------------------------------------------------------------------------------------------

    /**
     * The operator's operand.
     */
    public final Expression operand;

    // ---------------------------------------------------------------------------------------------

    public UnaryOperator (norswap.javalexer.tokens.Operator token,
                          Operator operator, Expression operand)
    {
        assert operator.operands == 1;
        this.token = token;
        this.operator = operator;
        this.operand = operand;
    }

    // ---------------------------------------------------------------------------------------------

    @Override public boolean equals (Object o)
    {
        if (this == o) return true;
        if (!(o instanceof UnaryOperator)) return false;
        UnaryOperator that = (UnaryOperator) o;
        return operand.equals(that.operand) && operator == that.operator;
    }

    // ---------------------------------------------------------------------------------------------

    @Override public int hashCode ()
    {
        int result = operand.hashCode();
        result = 31 * result + operator.hashCode();
        return result;
    }

    // ---------------------------------------------------------------------------------------------

    @Override public String toString () {
        return "(" + operand + "" + token.name + ")";
    }

    // ---------------------------------------------------------------------------------------------
}
