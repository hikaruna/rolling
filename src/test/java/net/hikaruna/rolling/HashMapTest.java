package net.hikaruna.rolling;

import org.junit.Test;

import java.util.Map.Entry;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("ALL")
public class HashMapTest {

    @Test
    public void testConstructor() {
        assertEquals(new java.util.HashMap(), new HashMap());
    }

    @Test
    public void testConstructorWithInitialCapacity() {
        assertEquals(new java.util.HashMap(5), new HashMap(5));
    }

    @Test
    public void testConstructorWithInitialCapacityAndLoadFactor() {
        assertEquals(new java.util.HashMap(5, 0.75f), new HashMap(5, 0.75f));
    }

    @Test
    public void testConstructorWithMAsNativeType() {
        final java.util.Map<String, Integer> m = new java.util.HashMap<>();
        assertEquals(new java.util.HashMap<>(m), new HashMap<>(m));
    }

    @Test
    public void testConstructorWithM() {
        final Map<String, Integer> m = new HashMap<>();
        assertEquals(new java.util.HashMap<>(m), new HashMap<>(m));
    }

    @Test
    public void testEach() {
        final Map<Integer, String> oneFourEight = createOneFourEight();

        final StringBuilder concat = new StringBuilder();

        oneFourEight.each(new VoidFunction<Entry<Integer, String>>() {
            @Override
            public void call(Entry<Integer, String> entry) {
                concat.append(entry.getKey());
                concat.append(entry.getValue());
            }
        });

        assertEquals("1a4b8c", concat.toString());
    }

    @Test
    public void testMap() {
        final List<String> repeatList = createOneFourEight().map(new Function<String, Entry<Integer, String>>() {
            @Override
            public String call(Entry<Integer, String> entry) {
                final StringBuilder sb = new StringBuilder();
                for (int i = 0; i < entry.getKey(); i++) {
                    sb.append(entry.getValue());
                }
                return sb.toString();
            }
        });
        assertEquals("a", repeatList.get(0));
        //noinspection SpellCheckingInspection
        assertEquals("bbbb", repeatList.get(1));
        //noinspection SpellCheckingInspection
        assertEquals("cccccccc", repeatList.get(2));
    }

    @Test
    public void testReduce() {
        final String concat = createOneFourEight().map(new Function<String, Entry<Integer, String>>() {
            @Override
            public String call(Entry<Integer, String> entry) {
                final StringBuilder sb = new StringBuilder();
                for (int i = 0; i < entry.getKey(); i++) {
                    sb.append(entry.getValue());
                }
                return sb.toString();
            }
        }).reduce("", new Function2<String, String, String>() {
            @Override
            public String call(String result, String item) {
                return result + item;
            }
        });

        //noinspection SpellCheckingInspection
        assertEquals("abbbbcccccccc", concat);
    }

    private Map<Integer, String> createOneFourEight() {
        final HashMap<Integer, String> oneFourEight = new HashMap<>();
        oneFourEight.put(1, "a");
        oneFourEight.put(4, "b");
        oneFourEight.put(8, "c");
        return oneFourEight;
    }
}