package net.hikaruna.rolling;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * {@link java.util.ArrayList}に、map-reduce等の機能を追加した拡張版.
 *
 * @see java.util.ArrayList
 */
@SuppressWarnings("WeakerAccess")
public class ArrayList<E> extends java.util.ArrayList<E> implements List<E> {

    private static final long serialVersionUID = 1054066276178532545L;

    /**
     * Constructs an empty list.
     *
     * @see java.util.ArrayList#ArrayList()
     */
    public ArrayList() {
        super();
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *                                  is negative
     * @see java.util.ArrayList#ArrayList(int)
     */
    public ArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * {@link java.util.ArrayList#ArrayList(Collection)}と同じ.
     *
     * @param c the collection whose elements are to be placed into this list
     */
    public ArrayList(@Nonnull final Collection<? extends E> c) {
        super(c);
    }

    @Override
    public void each(@Nonnull final VoidFunction<E> function) {
        for (final E i : this) {
            function.call(i);
        }
    }

    @Override
    public <Ret> ArrayList<Ret> map(@Nonnull final Function<Ret, E> function) {
        final ArrayList<Ret> result = new ArrayList<>(size());
        for (final E i : this) {
            result.add(function.call(i));
        }
        return result;
    }

    @Override
    public <Ret> Ret reduce(@Nonnull final Ret init, @Nonnull final Function2<Ret, Ret, E> function) {
        Ret result = init;
        for (final E i : this) {
            result = function.call(result, i);
        }
        return result;
    }
}
