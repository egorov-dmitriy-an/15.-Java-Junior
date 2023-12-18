package Homework;

import java.io.IOException;

public class Homework {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person man = new Person("Igor", 20);
        String loadPath = MetIO.saveObj(man);
        MetIO.loadObj(loadPath);
    }
}