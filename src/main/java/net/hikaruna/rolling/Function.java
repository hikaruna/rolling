package net.hikaruna.rolling;

/**
 * Function.
 *
 * @param <R> 返り値の型
 * @param <A> 引数の型
 */
public interface Function<R, A> extends ThrowsFunction<R, A, RuntimeException> {

    /**
     * Functionを評価する.
     *
     * @param a 引数
     * @return 返り値
     */
    @Override
    R call(A a);
}
