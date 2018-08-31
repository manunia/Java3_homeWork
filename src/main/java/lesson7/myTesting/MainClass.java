package lesson7.myTesting;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainClass {

    static void start(Class c) throws Exception{
        Method[] methods = c.getDeclaredMethods();
        int t = 0;
        int b = 0;
        for(Method m: methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                try {
                    System.out.println(m.getName());
                    m.invoke("init");
                    t++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (m.isAnnotationPresent(MyTest.class)) {
                try {
                    System.out.println(m.getName());
                    m.invoke(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                try {
                    System.out.println(m.getName());
                    m.invoke("end");
                    b++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (t > 1 || b > 1) {
                throw new RuntimeException();
            }
        }

    }

    public static void main(String[] args) {
        try {
            start(ClassTest.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
