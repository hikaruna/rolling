package net.hikaruna.rolling;

import net.hikaruna.rolling.function.*;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HashSetTest {

    @Test
    public void testConstructor() {
        assertEquals(new java.util.HashSet<Integer>(), new HashSet<Integer>());
    }

    @Test
    public void testConstructorWithCapacity() {
        final int capacity = 3;
        assertEquals(new java.util.HashSet<Integer>(capacity), new HashSet<Integer>(capacity));
    }

    @Test
    public void testConstructorWithCapacityAndLoadFactor() {
        final int capacity = 3;
        final float loadFactor = 0.7f;
        assertEquals(new java.util.HashSet<Integer>(capacity, loadFactor), new HashSet<Integer>(capacity, loadFactor));
    }

    @Test
    public void testConstructorWithCOfNativeCollection() {
        final java.util.Collection<String> c = Arrays.asList("a", "b", "c");
        assertEquals(new java.util.HashSet<CharSequence>(c), new HashSet<CharSequence>(c));
    }

    @Test
    public void testConstructorWithCOfRollingCollection() {
        final Collection<String> c = new ArrayList<>(Arrays.asList("a", "b", "c"));
        assertEquals(new java.util.HashSet<CharSequence>(c), new HashSet<CharSequence>(c));
    }

    @Test
    public void testEachWithConsumer() throws Exception {
        final HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1, 4, 8));
        final Set<Integer> squaredSet = new HashSet<>();

        hashSet.each(new Consumer<Integer>() {
            @Override
            public void accept(final Integer item) {
                squaredSet.add(item * item);
            }
        });

        assertEquals(3, squaredSet.size());
        assertTrue(squaredSet.containsAll(Arrays.asList(1, 16, 64)));
    }

    @Test
    public void testEachWithFunction() throws Exception {
        final HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1, 4, 8));
        final Set<Integer> squaredSet = new HashSet<>();

        hashSet.each(new Function<Integer, Void>() {
            @Override
            public Void apply(final Integer item) {
                squaredSet.add(item * item);
                return null;
            }
        });

        assertEquals(3, squaredSet.size());
        assertTrue(squaredSet.containsAll(Arrays.asList(1, 16, 64)));
    }

    @Test(expected = TestException.class)
    public void testEachWithThrowableFunction() throws TestException {
        final HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1, 4, 8));

        hashSet.each(new ThrowableFunction<Integer, Void, TestException>() {
            @Override
            public Void apply(final Integer item) throws TestException {
                throw new TestException();
            }
        });
    }

    @Test
    public void map() throws Exception {
        final HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1, 4, 8));

        final Set<Integer> squaredSet = hashSet.map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(final Integer item) {
                return item * item;
            }
        });

        assertEquals(3, squaredSet.size());
        assertTrue(squaredSet.containsAll(Arrays.asList(1, 16, 64)));
    }

    @Test(expected = TestException.class)
    public void mapWithThrowsFunction() throws Exception {
        final HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1, 4, 8));

        hashSet.map(new ThrowableFunction<Integer, Integer, TestException>() {
            @Override
            public Integer apply(final Integer integer) throws TestException {
                throw new TestException();
            }
        });
    }

    @Test
    public void testReduceWithReducer() {
        final HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1, 4, 8));

        final int sum = hashSet.reduce(0, new Enumerable.Reducer<Integer, Integer>() {
            @Override
            public Integer apply(final Integer result, final Integer item) {
                return result + item;
            }
        });

        assertEquals(13, sum);
    }

    @Test(expected = TestException.class)
    public void testReduceWithThrowableReducer() throws TestException {
        final HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1, 4, 8));

        hashSet.reduce(0, new Enumerable.ThrowableReducer<Integer, Integer, TestException>() {
            @Override
            public Integer apply(final Integer result, final Integer item) throws TestException {
                throw new TestException();
            }
        });
    }

    @Test
    public void testReduceWithBiFunction() {
        final HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1, 4, 8));

        final int sum = hashSet.reduce(0, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(final Integer result, final Integer item) {
                return result + item;
            }
        });

        assertEquals(13, sum);
    }

    @Test(expected = TestException.class)
    public void testReduceWithThrowableBiFunction() throws TestException {
        final HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1, 4, 8));

        hashSet.reduce(0, new ThrowableBiFunction<Integer, Integer, Integer, TestException>() {
            @Override
            public Integer apply(final Integer integer, final Integer integer2) throws TestException {
                throw new TestException();
            }
        });
    }
}