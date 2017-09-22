package net.hikaruna.rolling;

import net.hikaruna.rolling.function.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {

    private LinkedList<Integer> oneFourEight;

    @Before
    public void before() {
        oneFourEight = new LinkedList<>(Arrays.asList(1, 4, 8));
    }

    @Test
    public void testConstructor() {
        assertEquals(new java.util.LinkedList<>(), new LinkedList<>());
    }

    @Test
    public void testConstructorWithC() {
        final java.util.Collection<Integer> c = Arrays.asList(1, 4, 8);
        assertEquals(new java.util.LinkedList<>(c), new LinkedList<>(c));
    }

    @Test
    public void testEachWithConsumer() {
        final LinkedList<String> stringList = new LinkedList<>();
        oneFourEight.each(new Consumer<Integer>() {
            @Override
            public void accept(final Integer item) {
                stringList.add(String.valueOf(item));
            }
        });

        assertEquals(3, stringList.size());
        assertEquals("1", stringList.get(0));
        assertEquals("4", stringList.get(1));
        assertEquals("8", stringList.get(2));
    }

    @Test
    public void testEachWithFunction() {
        final LinkedList<String> stringList = new LinkedList<>();
        oneFourEight.each(new Function<Integer, Void>() {
            @Override
            public Void apply(final Integer item) {
                stringList.add(String.valueOf(item));
                return null;
            }
        });

        assertEquals(3, stringList.size());
        assertEquals("1", stringList.get(0));
        assertEquals("4", stringList.get(1));
        assertEquals("8", stringList.get(2));
    }

    @Test(expected = TestException.class)
    public void testEachWithThrowableFunction() throws TestException {
        oneFourEight.each(new ThrowableFunction<Integer, Void, TestException>() {
            @Override
            public Void apply(final Integer item) throws TestException {
                throw new TestException();
            }
        });
    }

    @Test
    public void testMapWithFunction() {
        final LinkedList<String> stringList = oneFourEight.map(new Function<Integer, String>() {
            @Override
            public String apply(final Integer item) {
                return String.valueOf(item);
            }
        });

        assertEquals(3, stringList.size());
        assertEquals("1", stringList.get(0));
        assertEquals("4", stringList.get(1));
        assertEquals("8", stringList.get(2));
    }

    @Test(expected = TestException.class)
    public void testMapWithThrowsFunction() throws TestException {
        oneFourEight.map(new ThrowableFunction<Integer, String, TestException>() {
            @Override
            public String apply(final Integer item) throws TestException {
                throw new TestException();
            }
        });
    }

    @Test
    public void testReduceWithReducer() {
        final int sum = oneFourEight.reduce(0, new Enumerable.Reducer<Integer, Integer>() {
            @Override
            public Integer apply(final Integer result, final Integer item) {
                return result + item;
            }
        });

        assertEquals(13, sum);
    }

    @Test(expected = TestException.class)
    public void testReduceWithThrowableReducer() throws TestException {
        oneFourEight.reduce(0, new Enumerable.ThrowableReducer<Integer, Integer, TestException>() {
            @Override
            public Integer apply(final Integer result, final Integer item) throws TestException {
                throw new TestException();
            }
        });
    }

    @Test
    public void testReduceWithBiFunction() {
        final int sum = oneFourEight.reduce(0, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(final Integer result, final Integer item) {
                return result + item;
            }
        });

        assertEquals(13, sum);
    }

    @Test(expected = TestException.class)
    public void testReduceWithThrowableBiFunction() throws TestException {
        oneFourEight.reduce(0, new ThrowableBiFunction<Integer, Integer, Integer, TestException>() {
            @Override
            public Integer apply(final Integer result, final Integer item) throws TestException {
                throw new TestException();
            }
        });
    }
}