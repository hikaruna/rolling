package net.hikaruna.rolling;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class ArrayListTest {

    @Test
    public void testEach() {
        final ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 4, 8));

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
}
