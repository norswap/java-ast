package norswap.javaast.nodes;

/**
 * Encapsulates a literal token.
 */
public final class Literal implements Expression
{
    // ---------------------------------------------------------------------------------------------

    /**
     * The token representing the literal.
     */
    public final norswap.javalexer.tokens.Literal token;

    // ---------------------------------------------------------------------------------------------

    public Literal (norswap.javalexer.tokens.Literal token) {
        this.token = token;
    }

    // ---------------------------------------------------------------------------------------------

    @Override public boolean equals (Object o) {
        return this == o || (o instanceof Literal) && token.equals(((Literal) o).token);
    }

    // ---------------------------------------------------------------------------------------------

    @Override public int hashCode () {
        return 31 + token.hashCode();
    }

    // ---------------------------------------------------------------------------------------------

    @Override public String toString () {
        return token.toString();
    }

    // ---------------------------------------------------------------------------------------------
}
