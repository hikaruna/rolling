package net.hikaruna.rolling;


import net.hikaruna.rolling.function.Function;
import net.hikaruna.rolling.function.ThrowableFunction;

import javax.annotation.Nonnull;
import java.util.Map.Entry;

/**
 * {@link java.util.Map}に、map-reduce等の機能を追加した拡張版.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public interface Map<K, V> extends java.util.Map<K, V>, Enumerable<Entry<K, V>> {

    @Override
    <R> List<R> map(@Nonnull Function<Entry<K, V>, R> function);

    @Override
    <R, Throws extends Throwable> List<R> map(@Nonnull ThrowableFunction<Entry<K, V>, R, Throws> function) throws Throws;
}
