package net.hikaruna.rolling.function;

/**
 * 1つの引数を受け取って結果を生成する関数を表します。
 *
 * @param <T> 関数の入力の型
 * @param <R> 関数の結果の型
 */
public interface Function<T, R> extends ThrowableFunction<T, R, RuntimeException> {

    /**
     * 指定された引数にこの関数を適用します。
     *
     * @param t 関数の引数
     * @return 関数の結果
     */
    @Override
    R apply(T t);
}
