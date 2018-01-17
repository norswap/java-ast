package norswap.javaast.nodes;

import norswap.javalexer.tokens.Operator;

/**
 * A unary operator expression.
 */
public final class UnaryOperator implements Expression
{
    // ---------------------------------------------------------------------------------------------

    /**
     * The unary operator specification.
     */
    public final OperatorSpec operator;

    // ---------------------------------------------------------------------------------------------

    /**
     * The token representing the operator.
     */
    public final Operator token;

    // ---------------------------------------------------------------------------------------------

    /**
     * The operator's operand.
     */
    public final Expression operand;

    // ---------------------------------------------------------------------------------------------

    public UnaryOperator (Operator token, OperatorSpec operator, Expression operand)
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
        return "Unary(" + token.name + ")(" + operand + ")";
    }

    // ---------------------------------------------------------------------------------------------
}
