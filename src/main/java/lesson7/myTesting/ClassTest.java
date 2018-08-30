package lesson7.myTesting;

public class ClassTest {

    static void start(Class c){

    }

    @BeforeSuite
    public static void init() {
        Calculator calculator = new Calculator();
    }

    @MyTest(priority = 2)
    public static void test1() {

    }

    @AfterSuite
    public static void end() {
        System.out.println("End");
    }
}
