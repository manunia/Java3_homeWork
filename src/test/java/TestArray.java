import lesson6.Lesson6MainClass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestArray {

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1,7}, new int[]{1,2,4,4,2,3,4,1,7}},
                {new int[]{1,7}, new int[]{1,2,0,0,2,3,4,1,7}},
                {new int[]{}, new int[]{-1,0,40,555,4}},
        });
    }

    Lesson6MainClass mainClass;

    private int[] expected;
    private int[] actuals;

    private int[] expRunTimeEx = {};
    private int[] actualsRunTimeEx = {-1,0,40,555};

    public TestArray(int[] expected, int[] actuals) {
        this.expected = expected;
        this.actuals = actuals;
    }

    //Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    //Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
    @Before
    public void init(){
        mainClass = new Lesson6MainClass();
    }

    @Test
    public void testArray1(){
        Assert.assertArrayEquals(expected,mainClass.array(actuals));
    }

    @Test(timeout = 100, expected = RuntimeException.class)
    public void testArray3(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertArrayEquals(expRunTimeEx,mainClass.array(actualsRunTimeEx));
    }

    @After
    public void end() {
        System.out.println("END");
    }
}
