package net.hikaruna.rolling;

import net.hikaruna.rolling.function.BiFunction;
import net.hikaruna.rolling.function.Consumer;
import net.hikaruna.rolling.function.Function;
import net.hikaruna.rolling.function.ThrowableFunction;

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
     * 各要素を{@link BiFunction}に渡して処理して集約し、その結果を返します
     *
     * @param init     最初のresultの値
     * @param function 評価内容{@code function(R init, E item)}
     * @param <R>      処理結果の型
     * @return 集約した処理結果
     */
    <R> R reduce(@Nonnull R init, @Nonnull BiFunction<R, E, R> function);
}
