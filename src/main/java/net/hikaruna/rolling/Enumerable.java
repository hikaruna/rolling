package net.hikaruna.rolling;

import net.hikaruna.rolling.function.*;

import javax.annotation.Nonnull;

/**
 * 繰り返すことができる振る舞いを提供する.
 *
 * @param <E> the type of elements in this collection
 */
public interface Enumerable<E> {

    /**
     * 各要素に対してfunctionを評価します.
     *
     * @param consumer 評価内容
     */
    void each(@Nonnull Consumer<E> consumer);

    /**
     * {@link #each(Consumer)}と同じ.
     *
     * @param function 評価内容
     */
    void each(@Nonnull Function<E, Void> function);

    /**
     * {@link #each(Function)}の例外を投げられる版.
     *
     * @param function 評価内容
     * @param <Throws> 例外の型
     * @throws Throws 評価中に投げられた例外をそのままreThrowしたもの
     */
    <Throws extends Throwable> void each(@Nonnull ThrowableFunction<E, Void, Throws> function) throws Throws;

    /**
     * 各要素を順番に{@link Function}に渡して評価し、その結果で要素を置き換えたものを返します.
     *
     * @param function 評価内容
     * @param <R>      評価結果の型
     * @return 要素を置き換えた結果
     */
    <R> Enumerable<R> map(@Nonnull Function<E, R> function);

    /**
     * {@link #map(Function)}の例外を投げられる版.
     *
     * @param function 評価内容
     * @param <R>      評価結果の型
     * @param <Throws> 例外の型
     * @return 要素を置き換えた結果
     * @throws Throws 評価中に投げられた例外をそのままreThrowしたもの
     */
    <R, Throws extends Throwable> Enumerable<R> map(@Nonnull ThrowableFunction<E, R, Throws> function) throws Throws;

    /**
     * 各要素を引数に指定された関数に渡して処理して集約し、その結果を返します
     *
     * @param init    最初のresultの値
     * @param reducer 評価内容
     * @param <R>     処理結果の型
     * @return 集約した処理結果
     */
    <R> R reduce(@Nonnull final R init, @Nonnull Reducer<E, R> reducer);

    /**
     * {@link #reduce(Object, Reducer)}と同じ.
     *
     * @param init     最初のresultの値
     * @param function 評価内容
     * @param <R>      処理結果の型
     * @return 集約した処理結果
     */
    <R> R reduce(@Nonnull final R init, @Nonnull BiFunction<R, E, R> function);

    /**
     * {@link #reduce(Object, Reducer)}の例外を投げられる版.
     *
     * @param init     最初のresultの値
     * @param function 評価内容
     * @param <R>      処理結果の型
     * @param <Throws> 例外の型
     * @return 集約した処理結果
     */
    <R, Throws extends Throwable> R reduce(@Nonnull final R init, @Nonnull final ThrowableBiFunction<R, E, R, Throws> function) throws Throws;

    /**
     * Reduce処理のための各要素毎に行う処理.
     *
     * @param <T> 扱う対象の要素の型
     * @param <R> Reduce処理結果の型
     */
    interface Reducer<T, R> extends BiFunction<R, T, R> {

        /**
         * Reduce処理のための各要素毎に行う処理を実行する.
         *
         * @param result 前の処理までの結果, この値を書き換える必要はない
         * @param item   今回の処理で扱う要素
         * @return 今回の処理後の結果, これは次の処理のresultに渡される
         */
        @Override
        R apply(final R result, T item);
    }
}
