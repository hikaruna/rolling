package net.hikaruna.rolling;

/**
 * Function.
 *
 * @param <Ret> 返り値の型
 * @param <Arg> 引数の型
 */
@SuppressWarnings("WeakerAccess")
public interface Function<Ret, Arg> {

    /**
     * Functionを評価する.
     *
     * @param arg 引数
     * @return 返り値
     */
    Ret call(Arg arg);
}
