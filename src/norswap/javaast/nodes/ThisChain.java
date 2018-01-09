package norswap.javaast.nodes;

/**
 * Access to an enclosing class' fields or methods.
 */
public class ThisChain implements IdentifierChain
{
    // ---------------------------------------------------------------------------------------------

    /**
     * The "this" reference in use.
     */
    public final This qualifier;

    // ---------------------------------------------------------------------------------------------

    /**
     * The mandatory identifier chain following the "this reference.
     */
    public final SimpleIdentifierChain suffix;

    // ---------------------------------------------------------------------------------------------

    public ThisChain (This qualifier, SimpleIdentifierChain suffix)
    {
        this.qualifier = qualifier;
        this.suffix = suffix;
    }

    // ---------------------------------------------------------------------------------------------

    @Override public boolean equals (Object o)
    {
        if (this == o) return true;
        if (!(o instanceof ThisChain)) return false;
        ThisChain that = (ThisChain) o;
        return qualifier.equals(that.qualifier)
            && suffix.equals(that.suffix);
    }

    // ---------------------------------------------------------------------------------------------

    @Override public int hashCode ()
    {
        int result = qualifier.hashCode();
        result = 31 * result + suffix.hashCode();
        return result;
    }

    // ---------------------------------------------------------------------------------------------

    @Override public String toString () {
        return qualifier + "." + suffix;
    }

    // ---------------------------------------------------------------------------------------------
}
