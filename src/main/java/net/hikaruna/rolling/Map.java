package net.hikaruna.rolling;


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
    <Ret> List<Ret> map(@Nonnull final Function<Ret, Entry<K, V>> function);
}
