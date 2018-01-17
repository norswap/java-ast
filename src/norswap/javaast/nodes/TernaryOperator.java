package norswap.javaast.nodes;

public class TernaryOperator implements Expression
{
    // ---------------------------------------------------------------------------------------------

    /**
     * Shorthand towards the tenary operator spec.
     */
    public static OperatorSpec operator = OperatorSpec.TERNARY;

    // ---------------------------------------------------------------------------------------------

    /**
     * The token representing the operator.
     */
    public final norswap.javalexer.tokens.Operator token;

    // ---------------------------------------------------------------------------------------------

    /**
     * The operator's first operand (the condition).
     */
    public final Expression op1;

    // ---------------------------------------------------------------------------------------------

    /**
     * The operator's second operand (the if-true part).
     */
    public final Expression op2;

    // ---------------------------------------------------------------------------------------------

    /**
     * The operator's third operand (the if-false part).
     */
    public final Expression op3;

    // ---------------------------------------------------------------------------------------------

    public TernaryOperator (norswap.javalexer.tokens.Operator token,
                            Expression op1, Expression op2, Expression op3)
    {
        this.token = token;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
    }

    // ---------------------------------------------------------------------------------------------

    @Override public boolean equals (Object o)
    {
        if (this == o) return true;
        if (!(o instanceof TernaryOperator)) return false;
        TernaryOperator that = (TernaryOperator) o;
        return op1.equals(that.op1)
            && op2.equals(that.op2)
            && op3.equals(that.op3);
    }

    // ---------------------------------------------------------------------------------------------

    @Override public int hashCode ()
    {
        int result = op1.hashCode();
        result = 31 * result + op2.hashCode();
        result = 31 * result + op3.hashCode();
        return result;
    }

    // ---------------------------------------------------------------------------------------------

    @Override public String toString() {
        return "Ternary(" + op1 + " ? " + op2 + " : " + op3 + ")";
    }

    // ---------------------------------------------------------------------------------------------
}
