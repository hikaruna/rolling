package net.hikaruna.rolling;

import net.hikaruna.rolling.function.Function;
import net.hikaruna.rolling.function.ThrowableFunction;

import javax.annotation.Nonnull;

/**
 * {@link java.util.Collection}に、map-reduce等の機能を追加した拡張版.
 *
 * @param <E> the type of elements in this collection
 */
@SuppressWarnings("WeakerAccess")
public interface Collection<E> extends java.util.Collection<E>, Enumerable<E> {

    @Override
    <R> Collection<R> map(@Nonnull Function<E, R> function);

    @Override
    <R, Throws extends Throwable> Collection<R> map(@Nonnull ThrowableFunction<E, R, Throws> function) throws Throws;
}
