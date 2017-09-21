package net.hikaruna.rolling.function;

/**
 * 単一の入力引数を受け取って結果を返さないオペレーションを表します。
 *
 * @param <T> オペレーションの入力の型
 */
@SuppressWarnings("WeakerAccess")
public interface Consumer<T> {

    /**
     * 指定された引数でこのオペレーションを実行します。
     *
     * @param t 入力引数
     */
    void apply(T t);
}
