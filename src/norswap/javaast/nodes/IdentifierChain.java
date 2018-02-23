package norswap.javaast.nodes;

/**
 * Common super-interface for all identifier chains, namely {@link SimpleIdentifierChain} and
 * the two qualified versions: {@link ThisChain} and {@link SuperChain}.
 *
 * <p>While this interface extends {@link Expression}, an identifier chain does not always
 * designate an expression (it can designate a type, for instance).
 */
public interface IdentifierChain extends Expression {}
