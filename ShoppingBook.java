package com.training.app;

import java.util.List;
import java.util.Scanner;
/**
 * Topic :Core Java.
 * Day#:13.
 *
 * To demonstrate Online book store app and interfaces that are used.
 * @author aswitha.j(51973252).
 */
public interface ShoppingBook {
    List<Book> createBooks(Scanner sc, List<Book> bookList);
    List<Book> deleteBookDetails(Scanner sc, List<Book> bookList);
    List<Book> updateBooks(Scanner sc, List<Book> bookList);
    String displaySubMenu(Scanner sc, OnlineBookStoreApp app,
            List<Book> bookList);
    String showMenu(Scanner sc);
    void displayBooks(List<Book> bookList);
    User getUserDetails(Scanner sc, String bookName, List<Book> bookList);
void printBookDetails(User user);
}

