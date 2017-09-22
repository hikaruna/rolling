package net.hikaruna.rolling.function;

/**
 * 2つの引数を受け取って結果を生成する関数を表します。これは、Functionを、引数を2個取るように特殊化したものです。
 *
 * @param <T> 関数の第1引数の型
 * @param <U> 関数の第2引数の型
 * @param <R> 関数の結果の型
 */
@SuppressWarnings("WeakerAccess")
public interface BiFunction<T, U, R> extends ThrowableBiFunction<T, U, R, RuntimeException> {

    /**
     * 指定された引数にこの関数を適用します.
     *
     * @param t 関数の第1引数
     * @param u 関数の第2引数
     * @return 関数の結果
     */
    @Override
    R apply(@SuppressWarnings("unused") T t, @SuppressWarnings("unused") U u);
}
