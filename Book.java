package com.training.app;
/**
 * Topic :Core Java.
 * Day#:13.
 *
 * To demonstrate Online book store app and details about user.
 * @author aswitha.j(51973252).
 */
public class User {
    private String name;
    private int id;
    private Book book;
    public User() {
    }
public User(String nameParam, int idParam) {
super();
this.name = nameParam;
this.id = idParam;
}
public String getName() {
return name;
}
public void setName(String nameParam) {
this.name = nameParam;
}
public int getId() {
return id;
}
public void setId(int idParam) {
this.id = idParam;
}
public Book getBook() {
return book;
}
public void setBook(Book bookParam) {
this.book = bookParam;
}
}