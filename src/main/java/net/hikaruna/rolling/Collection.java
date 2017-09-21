package net.hikaruna.rolling;

import javax.annotation.Nonnull;

/**
 * {@link java.util.Collection}に、map-reduce等の機能を追加した拡張版.
 *
 * @param <E> the type of elements in this collection
 */
@SuppressWarnings("WeakerAccess")
public interface Collection<E> extends java.util.Collection<E>, Enumerable<E> {

    @Override
    <R> Collection<R> map(@Nonnull final Function<R, E> function);

    @Override
    <R, T extends Throwable> Collection<R> map(@Nonnull final ThrowsFunction<R, E, T> function) throws T;
}
