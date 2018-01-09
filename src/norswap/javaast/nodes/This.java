package norswap.javaast.nodes;

import norswap.javalexer.tokens.Keyword;
import java.util.Objects;

/**
 * A reference to the instance of either the current class or an enclosing class.
 */
public class This implements Node
{
    // ---------------------------------------------------------------------------------------------

    /**
     * The token representing the keyword.
     */
    public final Keyword keyword;

    // ---------------------------------------------------------------------------------------------

    /**
     * Optional type prefix (in principle, the type must be that of an enclosing class).
     * Might be null.
     */
    public final SimpleIdentifierChain type;

    // ---------------------------------------------------------------------------------------------

    public This (Keyword keyword, SimpleIdentifierChain type)
    {
        assert keyword.name.equals("this");
        this.keyword = keyword;
        this.type = type;
    }

    // ---------------------------------------------------------------------------------------------

    @Override public boolean equals (Object o)
    {
        if (this == o) return true;
        if (!(o instanceof This)) return false;
        This that = (This) o;
        return keyword.equals(that.keyword)
            && Objects.equals(type, that.type);
    }

    // ---------------------------------------------------------------------------------------------

    @Override public int hashCode ()
    {
        int result = keyword.hashCode();
        result = 31 * result + Objects.hashCode(type);
        return result;
    }

    // ---------------------------------------------------------------------------------------------

    @Override public String toString () {
        return (type != null ? type.toString() + "." : "") + "this";
    }

    // ---------------------------------------------------------------------------------------------
}
