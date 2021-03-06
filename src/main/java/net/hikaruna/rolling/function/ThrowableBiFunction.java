package net.hikaruna.rolling.function;

/**
 * 例外を投げる可能性のある、2つの引数を受け取って結果を生成する関数を表します。
 *
 * @param <T>      関数の第1引数の型
 * @param <U>      関数の第2引数の型
 * @param <R>      関数の結果の型
 * @param <Throws> 例外の型
 */
public interface ThrowableBiFunction<T, U, R, Throws extends Throwable> {

    /**
     * 指定された引数にこの関数を適用します。
     *
     * @param t 関数の第1引数
     * @param u 関数の第2引数
     * @return 関数の結果
     * @throws Throws 投げられる可能性のある例外
     */
    R apply(@SuppressWarnings("unused") T t, @SuppressWarnings("unused") U u) throws Throws;
}
