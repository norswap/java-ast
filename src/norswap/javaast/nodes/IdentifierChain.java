package norswap.javaast.nodes;

import norswap.javalexer.tokens.Identifier;
import norswap.utils.Strings;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * A chain of identifiers separated by dots.
 * <p>
 * Such a chain is necessarily ambiguous: the identifiers could be variables (only for single
 * components identifiers), fields, classes, package components and methods (only for the last
 * component).
 */
public final class IdentifierChain
{
    // ---------------------------------------------------------------------------------------------

    private final Identifier[] identifiers;

    // ---------------------------------------------------------------------------------------------

    /**
     * An immutable list of the identifier tokens composing this chain.
     */
    public final List<Identifier> list;

    // ---------------------------------------------------------------------------------------------

    public IdentifierChain (Identifier... identifiers)
    {
        this.identifiers = identifiers;
        this.list = Collections.unmodifiableList(Arrays.asList(identifiers));
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Returns a list of the names of the identifiers composing this chain.
     */
    public List<String> names()
    {
        return Stream.of(identifiers)
            .map(it -> it.value)
            .collect(toList());
    }

    // ---------------------------------------------------------------------------------------------

    @Override public boolean equals (Object o)
    {
        if (this == o) return true;
        if (!(o instanceof IdentifierChain)) return false;
        IdentifierChain that = (IdentifierChain) o;
        if (list.size() != that.list.size()) return false;
        for (int i = 0; i < list.size(); ++i)
            if (!list.get(i).equals(that.list.get(i)))
                return false;
        return true;
    }

    // ---------------------------------------------------------------------------------------------

    @Override public int hashCode ()
    {
        int code = 0;
        for (Identifier id: list)
            code = code * 31 + id.hashCode();
        return code;
    }

    // ---------------------------------------------------------------------------------------------

    @Override public String toString()
    {
        StringBuilder b = new StringBuilder();
        for (Identifier id: list)
            b.append(id.value).append('.');
        if (list.size() > 0)
            Strings.pop(b, 1);
        return b.toString();
    }

    // ---------------------------------------------------------------------------------------------
}
