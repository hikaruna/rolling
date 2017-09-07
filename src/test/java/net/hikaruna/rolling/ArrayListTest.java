package net.hikaruna.rolling;

import org.junit.Test;

import java.util.LinkedList;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static org.junit.Assert.*;

public class ArrayListTest {

    @Test
    public void testEach() {
        final ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(8);
        final LinkedList<Integer> linkedList = new LinkedList<>();
        arrayList.each(new VoidFunc<Integer>() {
            @Override
            public void call(Integer integer) {
                linkedList.add(integer * integer);
            }
        });
        assertEquals(Integer.valueOf(1), linkedList.get(0));
        assertEquals(Integer.valueOf(16), linkedList.get(1));
        assertEquals(Integer.valueOf(64), linkedList.get(2));
    }
}
