package net.hikaruna.rolling;

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
