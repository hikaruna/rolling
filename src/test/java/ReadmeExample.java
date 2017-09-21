import net.hikaruna.rolling.ArrayList;
import net.hikaruna.rolling.function.BiFunction;
import net.hikaruna.rolling.function.Function;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ReadmeExample {

    @Test
    public void test() {
        final ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 4, 8));

        final int mapReduceResult = arrayList.map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(final Integer item) {
                return item * item;
            }
        }).reduce(0, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(final Integer result, final Integer item) {
                return result + item;
            }
        });

        assertEquals(81, mapReduceResult);
    }
}
