package net.hikaruna.rolling;

import net.hikaruna.rolling.function.BiFunction;
import net.hikaruna.rolling.function.Consumer;
import net.hikaruna.rolling.function.Function;
import net.hikaruna.rolling.function.ThrowableFunction;

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
    public HashMap(final int initialCapacity) {
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
    public HashMap(final int initialCapacity, final float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    /**
     * see {@link java.util.HashMap#HashMap(java.util.Map)}.
     *
     * @param m the map whose mappings are to be placed in this map
     */
    public HashMap(@Nonnull final java.util.Map<? extends K, ? extends V> m) {
        super(m);
    }

    /**
     * see {@link java.util.HashMap#HashMap(java.util.Map)}.
     *
     * @param m the map whose mappings are to be placed in this map
     */
    public HashMap(@Nonnull final Map<? extends K, ? extends V> m) {
        super(m);
    }

    @Override
    public void each(@Nonnull final Consumer<Entry<K, V>> consumer) {
        each((Function<Entry<K, V>, Void>) consumer);
    }

    @Override
    public void each(@Nonnull final Function<Entry<K, V>, Void> function) {
        each((ThrowableFunction<Entry<K, V>, Void, RuntimeException>) function);
    }

    @Override
    public <Throws extends Throwable> void each(@Nonnull final ThrowableFunction<Entry<K, V>, Void, Throws> function) throws Throws {
        for (final Entry<K, V> i : entrySet()) {
            function.apply(i);
        }
    }

    @Override
    public <R> List<R> map(@Nonnull final Function<Entry<K, V>, R> function) {
        return map((ThrowableFunction<Entry<K, V>, R, RuntimeException>) function);
    }

    @Override
    public <R, Throws extends Throwable> List<R> map(@Nonnull final ThrowableFunction<Entry<K, V>, R, Throws> function) throws Throws {
        final ArrayList<R> result = new ArrayList<>(size());
        for (final Entry<K, V> i : entrySet()) {
            result.add(function.apply(i));
        }
        return result;
    }

    @Override
    public <R> R reduce(@Nonnull final R init, @Nonnull final Reducer<Entry<K, V>, R> reducer) {
        return reduce(init, (BiFunction<R, Entry<K, V>, R>) reducer);
    }

    @Override
    public <R> R reduce(@Nonnull final R init, @Nonnull final BiFunction<R, Entry<K, V>, R> function) {
        R result = init;
        for (final Entry<K, V> i : entrySet()) {
            result = function.apply(result, i);
        }
        return result;
    }
}
