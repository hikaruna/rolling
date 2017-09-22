package net.hikaruna.rolling;

import net.hikaruna.rolling.function.BiFunction;
import net.hikaruna.rolling.function.Consumer;
import net.hikaruna.rolling.function.Function;
import net.hikaruna.rolling.function.ThrowableFunction;

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
    public ArrayList(final int initialCapacity) {
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
    public void each(@Nonnull final Consumer<E> consumer) {
        each((Function<E, Void>) consumer);
    }

    @Override
    public void each(@Nonnull final Function<E, Void> function) {
        for (final E i : this) {
            function.apply(i);
        }
    }

    @Override
    public <R> ArrayList<R> map(@Nonnull final Function<E, R> function) {
        return map((ThrowableFunction<E, R, RuntimeException>) function);
    }

    @Override
    public <R, Throws extends Throwable> ArrayList<R> map(@Nonnull final ThrowableFunction<E, R, Throws> function) throws Throws {
        final ArrayList<R> result = new ArrayList<>(size());
        for (final E i : this) {
            result.add(function.apply(i));
        }
        return result;
    }

    @Override
    public <R> R reduce(@Nonnull final R init, @Nonnull final Reducer<E, R> reducer) {
        return reduce(init, (BiFunction<R, E, R>) reducer);
    }

    @Override
    public <R> R reduce(@Nonnull final R init, @Nonnull final BiFunction<R, E, R> function) {
        R result = init;
        for (final E i : this) {
            result = function.apply(result, i);
        }
        return result;
    }
}
