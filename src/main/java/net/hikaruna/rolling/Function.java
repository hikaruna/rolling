package net.hikaruna.rolling;

/**
 * Function.
 *
 * @param <R> 返り値の型
 * @param <A> 引数の型
 */
@SuppressWarnings("WeakerAccess")
public interface Function<R, A> {

    /**
     * Functionを評価する.
     *
     * @param a 引数
     * @return 返り値
     */
    R call(A a);
}
