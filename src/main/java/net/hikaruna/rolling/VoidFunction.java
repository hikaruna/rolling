package net.hikaruna.rolling;

/**
 * 返り値がvoidのFunction.
 *
 * @param <Arg> 引数の型
 */
@SuppressWarnings("WeakerAccess")
public interface VoidFunction<Arg> {

    /**
     * Functionを評価する.
     *
     * @param arg 引数
     */
    void call(Arg arg);
}
