package net.hikaruna.rolling;

import net.hikaruna.rolling.function.BiFunction;
import net.hikaruna.rolling.function.Consumer;
import net.hikaruna.rolling.function.Function;
import net.hikaruna.rolling.function.ThrowableFunction;

import javax.annotation.Nonnull;

/**
 * {@link java.util.HashSet}に、map-reduce等の機能を追加した拡張版.
 *
 * @param <E> the type of elements maintained by this set
 */
public class HashSet<E> extends java.util.HashSet<E> implements Set<E> {

    /**
     * see {@link java.util.HashSet#HashSet()}.
     */
    public HashSet() {
        super();
    }

    /**
     * see {@link java.util.HashSet#HashSet(int)}.
     *
     * @param initialCapacity the initial capacity of the hash table
     * @throws IllegalArgumentException if the initial capacity is less
     *                                  than zero
     */
    public HashSet(final int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * see {@link java.util.HashSet#HashSet(int, float)}.
     *
     * @param initialCapacity the initial capacity of the hash map
     * @param loadFactor      the load factor of the hash map
     * @throws IllegalArgumentException if the initial capacity is less
     *                                  than zero, or if the load factor is non positive
     */
    public HashSet(final int initialCapacity, final float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    /**
     * see {@link java.util.HashSet#HashSet(java.util.Collection)}.
     *
     * @param c the collection whose elements are to be placed into this set
     */
    public HashSet(@Nonnull final java.util.Collection<? extends E> c) {
        super(c);
    }

    /**
     * see {@link java.util.HashSet#HashSet(java.util.Collection)}.
     *
     * @param c the collection whose elements are to be placed into this set
     */
    public HashSet(@Nonnull final Collection<? extends E> c) {
        super(c);
    }

    @Override
    public void each(@Nonnull final Consumer<E> consumer) {
        each((Function<E, Void>) consumer);
    }

    @Override
    public void each(@Nonnull final Function<E, Void> function) {
        for (final E item : this) {
            function.apply(item);
        }
    }

    @Override
    public <R> HashSet<R> map(@Nonnull final Function<E, R> function) {
        return map((ThrowableFunction<E, R, RuntimeException>) function);
    }

    @Override
    public <R, Throws extends Throwable> HashSet<R> map(@Nonnull final ThrowableFunction<E, R, Throws> function) throws Throws {
        final HashSet<R> result = new HashSet<>(size());
        for (final E item : this) {
            result.add(function.apply(item));
        }
        return result;
    }

    @Override
    public <R> R reduce(@Nonnull final R init, @Nonnull final BiFunction<R, E, R> function) {
        R result = init;
        for (final E item : this) {
            result = function.apply(result, item);
        }
        return result;
    }
}
