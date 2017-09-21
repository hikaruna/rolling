package net.hikaruna.rolling;

import net.hikaruna.rolling.function.BiFunction;
import net.hikaruna.rolling.function.Consumer;
import net.hikaruna.rolling.function.Function;
import net.hikaruna.rolling.function.ThrowableFunction;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class ArrayListTest {

    @Test
    public void testConstructor() {
        assertEquals(new java.util.ArrayList(), new ArrayList());
    }

    @Test
    public void testConstructorWithInitialCapacity() {
        assertEquals(new java.util.ArrayList(5), new ArrayList(5));
    }

    @Test
    public void testConstructorWithC() {
        final Collection<Integer> c = new java.util.ArrayList<>();
        assertEquals(new java.util.ArrayList<>(c), new ArrayList<>(c));
    }

    @Test
    public void testEachWithConsumer() {
        final ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 4, 8));

        final LinkedList<Integer> squaredList = new LinkedList<>();
        arrayList.each(new Consumer<Integer>() {
            @Override
            public void accept(final Integer integer) {
                squaredList.add(integer * integer);
            }
        });
        assertEquals(Integer.valueOf(1), squaredList.get(0));
        assertEquals(Integer.valueOf(16), squaredList.get(1));
        assertEquals(Integer.valueOf(64), squaredList.get(2));
    }

    @Test
    public void testEachWithFunction() {
        final ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 4, 8));

        final LinkedList<Integer> squaredList = new LinkedList<>();
        arrayList.each(new Function<Integer, Void>() {
            @Override
            public Void apply(final Integer integer) {
                squaredList.add(integer * integer);
                return null;
            }
        });
        assertEquals(Integer.valueOf(1), squaredList.get(0));
        assertEquals(Integer.valueOf(16), squaredList.get(1));
        assertEquals(Integer.valueOf(64), squaredList.get(2));
    }

    @Test
    public void testMap() {
        final ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 4, 8));

        final ArrayList<Integer> squaredList = arrayList.map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(final Integer integer) {
                return integer * integer;
            }
        });
        assertEquals(Integer.valueOf(1), squaredList.get(0));
        assertEquals(Integer.valueOf(16), squaredList.get(1));
        assertEquals(Integer.valueOf(64), squaredList.get(2));
    }

    @Test(expected = TestException.class)
    public void testMapWithThrowsFunction() throws TestException {
        final ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 4, 8));

        arrayList.map(new ThrowableFunction<Integer, Integer, TestException>() {
            @Override
            public Integer apply(final Integer integer) throws TestException {
                throw new TestException();
            }
        });
    }

    @Test
    public void testReduce() {
        final ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 4, 8));

        final int sum = arrayList.reduce(0, new BiFunction<Integer, Integer, Integer>() {

            @Override
            public Integer apply(final Integer result, final Integer item) {
                return result + item;
            }
        });

        assertEquals(13, sum);
    }
}
