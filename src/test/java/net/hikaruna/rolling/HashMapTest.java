package net.hikaruna.rolling;

import net.hikaruna.rolling.function.BiFunction;
import net.hikaruna.rolling.function.Consumer;
import net.hikaruna.rolling.function.Function;
import net.hikaruna.rolling.function.ThrowableFunction;
import org.junit.Test;

import java.util.Map.Entry;

import static org.junit.Assert.assertEquals;

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
    public void testEachWithConsumer() {
        final Map<Integer, String> oneFourEight = createOneFourEight();

        final StringBuilder concat = new StringBuilder();

        oneFourEight.each(new Consumer<Entry<Integer, String>>() {
            @Override
            public void accept(final Entry<Integer, String> entry) {
                concat.append(entry.getKey());
                concat.append(entry.getValue());
            }
        });

        assertEquals("1a4b8c", concat.toString());
    }

    @Test
    public void testEachWithFunction() {
        final Map<Integer, String> oneFourEight = createOneFourEight();

        final StringBuilder concat = new StringBuilder();

        oneFourEight.each(new Function<Entry<Integer, String>, Void>() {
            @Override
            public Void apply(final Entry<Integer, String> entry) {
                concat.append(entry.getKey());
                concat.append(entry.getValue());
                return null;
            }
        });

        assertEquals("1a4b8c", concat.toString());
    }

    @Test(expected = TestException.class)
    public void testEachWithThrowableFunction() throws TestException {
        final Map<Integer, String> oneFourEight = createOneFourEight();

        oneFourEight.each(new ThrowableFunction<Entry<Integer, String>, Void, TestException>() {
            @Override
            public Void apply(final Entry<Integer, String> integerStringEntry) throws TestException {
                throw new TestException();
            }
        });
    }

    @Test
    public void testMap() {
        final List<String> repeatList = createOneFourEight().map(new Function<Entry<Integer, String>, String>() {
            @Override
            public String apply(final Entry<Integer, String> entry) {
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

    @Test(expected = TestException.class)
    public void testMapWithThrowsFunction() throws TestException {
        createOneFourEight().map(new ThrowableFunction<Entry<Integer, String>, String, TestException>() {
            @Override
            public String apply(final Entry<Integer, String> integerStringEntry) throws TestException {
                throw new TestException();
            }
        });
    }

    @Test
    public void testReduceWithReducer() {
        final String concat = createOneFourEight().map(new Function<Entry<Integer, String>, String>() {
            @Override
            public String apply(final Entry<Integer, String> entry) {
                final StringBuilder sb = new StringBuilder();
                for (int i = 0; i < entry.getKey(); i++) {
                    sb.append(entry.getValue());
                }
                return sb.toString();
            }
        }).reduce("", new Enumerable.Reducer<String, String>() {
            @Override
            public String apply(final String result, final String item) {
                return result + item;
            }
        });

        //noinspection SpellCheckingInspection
        assertEquals("abbbbcccccccc", concat);
    }

    @Test
    public void testReduceWithBiFunction() {
        final String concat = createOneFourEight().map(new Function<Entry<Integer, String>, String>() {
            @Override
            public String apply(final Entry<Integer, String> entry) {
                final StringBuilder sb = new StringBuilder();
                for (int i = 0; i < entry.getKey(); i++) {
                    sb.append(entry.getValue());
                }
                return sb.toString();
            }
        }).reduce("", new BiFunction<String, String, String>() {
            @Override
            public String apply(final String result, final String item) {
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