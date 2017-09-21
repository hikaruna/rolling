package net.hikaruna.rolling;

/**
 * Function.
 *
 * @param <R>  返り値の型
 * @param <A1> 第一引数の型
 * @param <A2> 第二引数の型
 */
@SuppressWarnings("WeakerAccess")
public interface Function2<R, A1, A2> {

    /**
     * Functionを評価する.
     *
     * @param a1 引数1
     * @param a2 引数2
     * @return 返り値
     */
    R call(A1 a1, A2 a2);
}
