package net.hikaruna.rolling;

import net.hikaruna.rolling.function.*;

import javax.annotation.Nonnull;


/**
 * {@link java.util.LinkedList}に、map-reduce等の機能を追加した拡張版.
 *
 * @see java.util.LinkedList
 */
public class LinkedList<E> extends java.util.LinkedList<E> implements List<E> {

    /**
     * @see java.util.LinkedList#LinkedList()
     */
    public LinkedList() {
        super();
    }

    /**
     * @see java.util.LinkedList#LinkedList(java.util.Collection)
     */
    public LinkedList(final java.util.Collection<E> c) {
        super(c);
    }

    @Override
    public void each(@Nonnull final Consumer<E> consumer) {
        each((Function<E, Void>) consumer);
    }

    @Override
    public void each(@Nonnull final Function<E, Void> function) {
        each((ThrowableFunction<E, Void, RuntimeException>) function);
    }

    @Override
    public <Throws extends Throwable> void each(@Nonnull final ThrowableFunction<E, Void, Throws> function) throws Throws {
        for (final E item : this) {
            function.apply(item);
        }
    }

    @Override
    public <R> LinkedList<R> map(@Nonnull final Function<E, R> function) {
        return map((ThrowableFunction<E, R, RuntimeException>) function);
    }

    @Override
    public <R, Throws extends Throwable> LinkedList<R> map(@Nonnull final ThrowableFunction<E, R, Throws> function) throws Throws {
        final LinkedList<R> result = new LinkedList<>();
        for (final E item : this) {
            result.add(function.apply(item));
        }
        return result;
    }

    @Override
    public <R> R reduce(@Nonnull final R init, @Nonnull final Reducer<E, R> reducer) {
        return reduce(init, (ThrowableReducer<E, R, RuntimeException>) reducer);
    }

    @Override
    public <R, Throws extends Throwable> R reduce(@Nonnull final R init, @Nonnull final ThrowableReducer<E, R, Throws> reducer) throws Throws {
        return reduce(init, (ThrowableBiFunction<R, E, R, Throws>) reducer);
    }

    @Override
    public <R> R reduce(@Nonnull final R init, @Nonnull final BiFunction<R, E, R> function) {
        return reduce(init, (ThrowableBiFunction<R, E, R, RuntimeException>) function);
    }

    @Override
    public <R, Throws extends Throwable> R reduce(@Nonnull final R init, @Nonnull final ThrowableBiFunction<R, E, R, Throws> function) throws Throws {
        R result = init;
        for (final E item : this) {
            result = function.apply(result, item);
        }
        return result;
    }
}
