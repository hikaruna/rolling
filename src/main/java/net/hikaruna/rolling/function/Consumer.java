package net.hikaruna.rolling.function;

/**
 * 単一の入力引数を受け取って結果を返さないオペレーションを表します。
 *
 * @param <T> オペレーションの入力の型
 */
@SuppressWarnings("WeakerAccess")
public abstract class Consumer<T> implements Function<T, Void> {

    /**
     * 指定された引数でこのオペレーションを実行します。
     *
     * @param t 入力引数
     */
    public abstract void accept(T t);

    @Override
    public Void apply(final T t) {
        accept(t);
        return null;
    }
}
