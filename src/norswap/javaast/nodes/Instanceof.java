package norswap.javaast.nodes;

public class Instanceof implements Expression
{
    // ---------------------------------------------------------------------------------------------

    public final Expression operand;

    // ---------------------------------------------------------------------------------------------

    // TODO TYPE

    // ---------------------------------------------------------------------------------------------

    public Instanceof (Expression operand)
    {
        this.operand = operand;
    }

    // ---------------------------------------------------------------------------------------------
}