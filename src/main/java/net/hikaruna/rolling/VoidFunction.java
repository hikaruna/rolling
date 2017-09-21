package net.hikaruna.rolling;

/**
 * 返り値がvoidのFunction.
 *
 * @param <A> 引数の型
 */
@SuppressWarnings("WeakerAccess")
public interface VoidFunction<A> {

    /**
     * Functionを評価する.
     *
     * @param a 引数
     */
    void call(A a);
}
