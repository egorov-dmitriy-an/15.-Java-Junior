package org.example;

import javax.persistence.*;
@Entity
@Table (name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String author;

    @Column
    private String name;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Book() {
            }
    public Book(String author, String name) {
        this.author = author;
        this.name = name;
    }
}