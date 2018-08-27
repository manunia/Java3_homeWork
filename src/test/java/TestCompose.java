import lesson6.Lesson6MainClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestCompose {

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1,2,4,4,2,3,4,1,7},true},
                {new int[]{1,2,0,0,2,3,0,1,7},true},
                {new int[]{-1,0,40,555,0},false}
        });
    }


    private int[] arr;
    private boolean bool;

    public TestCompose(int[] arr, boolean bool) {
        this.arr = arr;
        this.bool = bool;
    }
    Lesson6MainClass mainClass;

    @Before
    public void init() {
        mainClass = new Lesson6MainClass();
    }

    @Test
    public void testCompose1() {
        Assert.assertEquals(bool,mainClass.composition(arr));
    }
}
