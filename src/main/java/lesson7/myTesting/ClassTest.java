package lesson7.myTesting;


public class ClassTest {

    @BeforeSuite
    public static void init() {
        System.out.println("Start");
    }

    @MyTest(priority = 5)
    public static void test1() {
        System.out.println("testing ...");
    }

    @MyTest(priority = 2)
    public static void test2() {
        System.out.println("testing...");
    }

    @AfterSuite
    public static void end() {
        System.out.println("End");
    }

}
