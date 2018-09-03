import lesson8_test.IntCounter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestIntCounter {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[] {5,2,3},"1 2 3 2 3 1 1 1 1 3"}
        });
    }

    private IntCounter ic;
    private int[] out;
    private String in;

    public TestIntCounter(int[] out, String in) {
        this.out = out;
        this.in = in;
    }

    @Before
    public void init() {
        ic = new IntCounter();

    }


    @Test
    public void testOut() {
        Assert.assertArrayEquals(out,ic.out(ic.counter(ic.getMass(in))));
    }
}
