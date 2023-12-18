package Homework;

import java.io.Serial;
import java.io.Serializable;

public class Person implements Serializable {
    @Serial
    static final long serialVersionUID = 1L;
    private final String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}