package net.hikaruna.rolling;

import javax.annotation.Nonnull;

/**
 * {@link java.util.List}に、map-reduce等の機能を追加した拡張版.
 *
 * @param <E> the type of elements maintained by this set
 */
public interface Set<E> extends java.util.Set<E>, Collection<E> {

    @Override
    <Ret> Set<Ret> map(@Nonnull final Function<Ret, E> function);
}
