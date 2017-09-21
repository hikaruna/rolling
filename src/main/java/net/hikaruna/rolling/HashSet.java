package net.hikaruna.rolling;

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
    public HashSet(int initialCapacity) {
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
    public HashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    /**
     * see {@link java.util.HashSet#HashSet(java.util.Collection)}.
     *
     * @param c the collection whose elements are to be placed into this set
     */
    public HashSet(@Nonnull java.util.Collection<? extends E> c) {
        super(c);
    }

    /**
     * see {@link java.util.HashSet#HashSet(java.util.Collection)}.
     *
     * @param c the collection whose elements are to be placed into this set
     */
    public HashSet(@Nonnull Collection<? extends E> c) {
        super(c);
    }

    @Override
    public void each(@Nonnull final VoidFunction<E> function) {
        for (final E item : this) {
            function.call(item);
        }
    }

    @Override
    public <R> HashSet<R> map(@Nonnull final Function<R, E> function) {
        return map((ThrowsFunction<R, E, RuntimeException>) function);
    }

    @Override
    public <R, T extends Throwable> HashSet<R> map(@Nonnull final ThrowsFunction<R, E, T> function) throws T {
        final HashSet<R> result = new HashSet<>(size());
        for (final E item : this) {
            result.add(function.call(item));
        }
        return result;
    }

    @Override
    public <R> R reduce(@Nonnull final R init, @Nonnull final Function2<R, R, E> function) {
        R result = init;
        for (final E item : this) {
            result = function.call(result, item);
        }
        return result;
    }
}
