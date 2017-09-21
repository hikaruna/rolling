package net.hikaruna.rolling;


/**
 * 例外を投げる可能性のあるFunction.
 *
 * @param <R> 返り値の型
 * @param <A> 引数の型
 * @param <T> 例外の型
 */
@SuppressWarnings("WeakerAccess")
public interface ThrowsFunction<R, A, T extends Throwable> {
    R call(A arg) throws T;
}
