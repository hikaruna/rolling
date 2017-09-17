package net.hikaruna.rolling;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * {@link java.util.ArrayList}に、map-reduce等の機能を追加した拡張版.
 *
 * @see java.util.ArrayList
 */
@SuppressWarnings("WeakerAccess")
public class ArrayList<E> extends java.util.ArrayList<E> {

    private static final long serialVersionUID = 1054066276178532545L;

    /**
     * {@link java.util.ArrayList#ArrayList(Collection)}と同じ.
     *
     * @param c the collection whose elements are to be placed into this list
     */
    public ArrayList(@Nonnull final Collection<? extends E> c) {
        super(c);
    }

    /**
     * 各要素に対してfunctionを評価します.
     *
     * @param function 評価内容
     */
    public void each(@Nonnull final VoidFunction<E> function) {
        for (final E i : this) {
            function.call(i);
        }
    }
}
