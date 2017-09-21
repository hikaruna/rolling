package net.hikaruna.rolling;

import javax.annotation.Nonnull;
import java.util.Map.Entry;

public class HashMap<K, V> extends java.util.HashMap<K, V> implements Map<K, V> {

    /**
     * see {@link java.util.HashMap#HashMap()}.
     */
    public HashMap() {
        super();
    }

    /**
     * see {@link java.util.HashMap#HashMap(int)}.
     *
     * @param initialCapacity the initial capacity.
     * @throws IllegalArgumentException if the initial capacity is negative.
     */
    public HashMap(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * see {@link java.util.HashMap#HashMap(int, float)}.
     *
     * @param initialCapacity the initial capacity
     * @param loadFactor      the load factor
     * @throws IllegalArgumentException if the initial capacity is negative
     *                                  or the load factor is non positive
     */
    public HashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    /**
     * see {@link java.util.HashMap#HashMap(java.util.Map)}.
     *
     * @param m the map whose mappings are to be placed in this map
     */
    public HashMap(@Nonnull java.util.Map<? extends K, ? extends V> m) {
        super(m);
    }

    /**
     * see {@link java.util.HashMap#HashMap(java.util.Map)}.
     *
     * @param m the map whose mappings are to be placed in this map
     */
    public HashMap(@Nonnull Map<? extends K, ? extends V> m) {
        super(m);
    }

    @Override
    public void each(@Nonnull final VoidFunction<Entry<K, V>> function) {
        for (final Entry<K, V> i : entrySet()) {
            function.call(i);
        }
    }

    @Override
    public <R> List<R> map(@Nonnull final Function<R, Entry<K, V>> function) {
        final ArrayList<R> result = new ArrayList<>(size());
        for (final Entry<K, V> i : entrySet()) {
            result.add(function.call(i));
        }
        return result;
    }

    @Override
    public <R> R reduce(@Nonnull final R init, @Nonnull final Function2<R, R, Entry<K, V>> function) {
        R result = init;
        for (final Entry<K, V> i : entrySet()) {
            result = function.call(result, i);
        }
        return result;
    }
}
