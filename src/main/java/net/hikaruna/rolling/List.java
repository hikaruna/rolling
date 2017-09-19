package net.hikaruna.rolling;

import javax.annotation.Nonnull;

/**
 * {@link java.util.List}に、map-reduce等の機能を追加した拡張版.
 *
 * @param <E> the type of elements in this list
 */
@SuppressWarnings("WeakerAccess")
public interface List<E> extends java.util.List<E>, Collection<E> {

    @Override
    <Ret> List<Ret> map(@Nonnull final Function<Ret, E> function);
}
