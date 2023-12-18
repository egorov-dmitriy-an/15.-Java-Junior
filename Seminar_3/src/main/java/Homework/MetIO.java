package Homework;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class MetIO {
    public static String saveObj(Object object) throws IOException {
        String nameClass = object.getClass().getName();
        String id = UUID.randomUUID().toString();
        Path saveFile = Path.of(nameClass + "_" + id);
        System.out.println(saveFile);

        OutputStream outputStream = Files.newOutputStream(saveFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        return (nameClass + "_" + id);
    }

    public static <T> void loadObj(String nameFile) throws IOException, ClassNotFoundException {

        Path loadPath = Path.of(nameFile);
        InputStream inputStream = Files.newInputStream(loadPath);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        T deserializable = (T) objectInputStream.readObject();
        System.out.println(deserializable);
        Files.delete(loadPath);
        objectInputStream.close();
    }
}