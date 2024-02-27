package org.example;

//* 1. С помощью JDBC выполнить:
//        * 1.1 Создать таблицу book с колонками id bigint, name varchar, author varchar
//        * 1.2 Добавить в таблицу 10 книг
//        * 1.3 Сделать запрос select from book where author = 'какое-то имя' и прочитать его с помощью ResultSet

import java.sql.*;

public class Jdbc {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:file:./src/main/resources/database.db");
        prepareTables(connection);
        insertData(connection);
        executeSelect(connection);
        connection.close();
    }

    private static void prepareTables(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("""
                    DROP TABLE IF EXISTS book;
                    CREATE TABLE book (
                    id BIGINT,
                    author VARCHAR (255),
                    name VARCHAR (255));
                    """);
        }
    }

    private static void insertData(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("insert into book(id, author, name)" +
                    " values (1, 'Pushkin', 'Ruslan i Ludmila')," +
                    " (2, 'Pushkin', 'Poltava')," +
                    " (3, 'Pushkin', 'Medny vsadnik')," +
                    " (4, 'Pushkin', 'Boris Godunov')," +
                    " (5, 'Pushkin', 'Dubrovsky ')," +
                    " (6, 'Lermontov', 'A Hero of Our Time')," +
                    " (7, 'Lermontov', 'Death of the Poet')," +
                    " (8, 'Lermontov', 'Masquerade')," +
                    " (9, 'Gogol', 'The Nose')," +
                    " (10, 'Gogol', 'Viy')");
        }
    }

    private static void executeSelect(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select id, author, name from book where author = 'Gogol';");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String author = resultSet.getString("author");
                String name = resultSet.getString("name");
                System.out.println("id = " + id + ", author = " + author + ", name = " + name);
            }
        }
    }
}
