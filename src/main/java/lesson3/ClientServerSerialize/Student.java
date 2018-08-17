package lesson3.ClientServerSerialize;

import java.io.Serializable;

public class Student implements Serializable {

    public static void main(String[] args) {
        new Student("Ivan",15,33);
    }

    private String name;
    private int age;
    private int group;

    public Student(String name, int age, int group) {
        this.name = name;
        this.age = age;
        this.group = group;
        info();
    }

    public void info() {
        System.out.println("Student: " + name + ", " + age + ", " + group + ".");
    }
}
