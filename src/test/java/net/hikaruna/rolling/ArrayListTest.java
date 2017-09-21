package net.hikaruna.rolling;

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
        Collection<Integer> c = new java.util.ArrayList<>();
        assertEquals(new java.util.ArrayList<>(c), new ArrayList<>(c));
    }

    @Test
    public void testEach() {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 4, 8));

        final LinkedList<Integer> squaredList = new LinkedList<>();
        arrayList.each(new VoidFunction<Integer>() {
            @Override
            public void call(Integer integer) {
                squaredList.add(integer * integer);
            }
        });
        assertEquals(Integer.valueOf(1), squaredList.get(0));
        assertEquals(Integer.valueOf(16), squaredList.get(1));
        assertEquals(Integer.valueOf(64), squaredList.get(2));
    }

    @Test
    public void testMap() {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 4, 8));

        ArrayList<Integer> squaredList = arrayList.map(new Function<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                return integer * integer;
            }
        });
        assertEquals(Integer.valueOf(1), squaredList.get(0));
        assertEquals(Integer.valueOf(16), squaredList.get(1));
        assertEquals(Integer.valueOf(64), squaredList.get(2));
    }

    @Test(expected = TestException.class)
    public void testMapWithThrowsFunction() throws TestException {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 4, 8));

        arrayList.map(new ThrowsFunction<Integer, Integer, TestException>() {
            @Override
            public Integer call(Integer integer) throws TestException {
                throw new TestException();
            }
        });
    }

    @Test
    public void testReduce() {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 4, 8));

        int sum = arrayList.reduce(0, new Function2<Integer, Integer, Integer>() {

            @Override
            public Integer call(Integer result, Integer item) {
                return result + item;
            }
        });

        assertEquals(13, sum);
    }
}
