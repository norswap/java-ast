package norswap.javaast.nodes;

import norswap.javalexer.tokens.Keyword;
import java.util.Objects;

/**
 * Access to superclass fields or methods.
 */
public class SuperChain implements IdentifierChain
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

    /**
     * Mandatory identifier chain suffix designating a chain of fields and/or a method through
     * starting at the superclass.
     */
    public final SimpleIdentifierChain suffix;

    // ---------------------------------------------------------------------------------------------

    public SuperChain (Keyword keyword, SimpleIdentifierChain type, SimpleIdentifierChain suffix)
    {
        assert keyword.name.equals("super");
        this.keyword = keyword;
        this.type = type;
        this.suffix = suffix;
    }

    // ---------------------------------------------------------------------------------------------

    @Override public boolean equals (Object o)
    {
        if (this == o) return true;
        if (!(o instanceof SuperChain)) return false;
        SuperChain that = (SuperChain) o;
        return keyword.equals(that.keyword)
            && Objects.equals(type, that.type)
            && Objects.equals(suffix, that.suffix);
    }

    // ---------------------------------------------------------------------------------------------

    @Override public int hashCode ()
    {
        int result = keyword.hashCode();
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(suffix);
        return result;
    }

    // ---------------------------------------------------------------------------------------------

    @Override public String toString () {
        return (type != null ? type.toString() + "." : "") + "super." + suffix;
    }

    // ---------------------------------------------------------------------------------------------
}
