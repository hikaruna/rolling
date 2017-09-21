package net.hikaruna.rolling;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HashSetTest {

    @Test
    public void testConstructor() {
        assertEquals(new java.util.HashSet<Integer>(), new HashSet<Integer>());
    }

    @Test
    public void testConstructorWithCapacity() {
        int capacity = 3;
        assertEquals(new java.util.HashSet<Integer>(capacity), new HashSet<Integer>(capacity));
    }

    @Test
    public void testConstructorWithCapacityAndLoadFactor() {
        int capacity = 3;
        float loadFactor = 0.7f;
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
    public void each() throws Exception {
        final HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1, 4, 8));
        final Set<Integer> squaredSet = new HashSet<>();

        hashSet.each(new VoidFunction<Integer>() {

            @Override
            public void call(Integer item) {
                squaredSet.add(item * item);
            }
        });

        assertEquals(3, squaredSet.size());
        assertTrue(squaredSet.containsAll(Arrays.asList(1, 16, 64)));
    }

    @Test
    public void map() throws Exception {
        final HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1, 4, 8));

        final Set<Integer> squaredSet = hashSet.map(new Function<Integer, Integer>() {
            @Override
            public Integer call(Integer item) {
                return item * item;
            }
        });

        assertEquals(3, squaredSet.size());
        assertTrue(squaredSet.containsAll(Arrays.asList(1, 16, 64)));
    }

    @Test
    public void reduce() throws Exception {
        final HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1, 4, 8));

        int sum = hashSet.reduce(0, new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(final Integer result, Integer item) {
                return result + item;
            }
        });

        assertEquals(13, sum);
    }
}