package net.hikaruna.rolling;

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
     * @param function 評価内容
     */
    void each(@Nonnull final VoidFunction<E> function);

    /**
     * 各要素を順番に{@link Function}に渡して評価し、その結果で要素を置き換えたものを返します.
     *
     * @param function 評価内容
     * @param <R>    評価結果の型
     * @return 要素を置き換えた結果
     */
    <R> Enumerable<R> map(@Nonnull final Function<R, E> function);

    /**
     * 各要素を{@link Function2}に渡して処理して集約し、その結果を返します
     *
     * @param init     最初のresultの値
     * @param function 評価内容{@code function(R init, E item)}
     * @param <R>    処理結果の型
     * @return 集約した処理結果
     */
    <R> R reduce(@Nonnull final R init, @Nonnull final Function2<R, R, E> function);
}
