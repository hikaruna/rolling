package net.hikaruna.rolling;

/**
 * Function.
 *
 * @param <Ret>  返り値の型
 * @param <Arg1> 第一引数の型
 * @param <Arg2> 第二引数の型
 */
@SuppressWarnings("WeakerAccess")
public interface Function2<Ret, Arg1, Arg2> {

    /**
     * Functionを評価する.
     *
     * @param arg1 引数1
     * @param arg2 引数2
     * @return 返り値
     */
    Ret call(Arg1 arg1, Arg2 arg2);
}
