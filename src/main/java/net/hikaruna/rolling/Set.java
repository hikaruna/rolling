package net.hikaruna.rolling;

import net.hikaruna.rolling.function.Function;
import net.hikaruna.rolling.function.ThrowableFunction;

import javax.annotation.Nonnull;

/**
 * {@link java.util.List}に、map-reduce等の機能を追加した拡張版.
 *
 * @param <E> the type of elements maintained by this set
 */
public interface Set<E> extends java.util.Set<E>, Collection<E> {

    @Override
    <R> Set<R> map(@Nonnull Function<E, R> function);

    @Override
    <R, Throws extends Throwable> Set<R> map(@Nonnull ThrowableFunction<E, R, Throws> function) throws Throws;
}
