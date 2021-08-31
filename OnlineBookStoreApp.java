package com.training.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Topic :Core Java. Day#:13.
 *
 * To demonstrate Online book store app.
 * @author aswitha.j(51973252).
 */
public class OnlineBookStoreApp implements ShoppingBook {
    public static void main(String[] args) {
        System.out.println("**********************************" + "\n\n"
                + "Welcome to MyCompany Online " + "Book Store Application\n");
        Scanner sc = new Scanner(System.in);
        OnlineBookStoreApp app = new OnlineBookStoreApp();
        List<Book> bookList = new ArrayList<>();
        String option = "";
        while (!option.equals("Quit")) {
            option = app.showMenu(sc);
            switch (option) {
            case "1":
                bookList = app.createBooks(sc, bookList);
                break;
            case "2":
                bookList = app.updateBooks(sc, bookList);
                break;
            case "3":
                app.printBookDetails(app.getUserDetails(sc,
                        app.displaySubMenu(sc, app, bookList),
               bookList));
                break;
            case "4":
                bookList = app.deleteBookDetails(sc, bookList);
                break;
            case "Quit":
                break;
            default:
                System.out.println("You have entered" + " a invalid option.");
                break;
            }
        }
        sc.close();
        System.out.println("   Thanks. Welcome Again"
                + "....... " + "          \r\n");
        System.out.println("******************************************"
                + "***********************************" + "*****************");
    }
    @Override
    public List<Book> deleteBookDetails(Scanner sc, List<Book> bookList) {
        if  (bookList.isEmpty()) {
            System.out.println("Sorry the list is empty");
        }
        else {
        System.out.println("Enter the Book name:");
        String bookName = sc.nextLine();
        for (Book book : bookList) {
            if (book.getBookName().equals(bookName)) {
                bookList.remove(book);
                break;
            }
        }
       }
        return bookList;
    }

    @Override
    public String displaySubMenu(Scanner sc, OnlineBookStoreApp app,
            List<Book> bookList) {
        System.out.println("Select the Book from below");
        System.out.println(" \t\t_______________________" + "__"
                + "____________\r\n");
        app.displayBooks(bookList);
        System.out.println(" \t\t_____________________" + "__________"
                + "______\r\n");
        System.out.println("Enter the Book Name:");
        String bookName = sc.nextLine();
        return bookName;
    }

    // Show the Menu options to the user to select.
    @Override
    public String showMenu(Scanner sc) {
        String option;
        System.out.println("Choose from below Menu Option");
        System.out.println(" \t\t________________________________"
        + "________\r\n");
        System.out.println("\t\t1: Add New Book");
        System.out.println("\t\t2: Edit existing Book");
        System.out.println("\t\t3: Buy Book");
        System.out.println("\t\t4: Delete Book");
        System.out.println("\t\tQuit: Stop the process.\n");
        System.out.println(" \t\t______________________________"
        + "__________\r\n");
        System.out.println("Enter Your Option:");
        option = sc.nextLine();
        return option;
    }

    // Prepare the Books List.
    @Override
    public List<Book> createBooks(Scanner sc, List<Book> bookList) {
        System.out.println("Enter Book Name:");
        String name = sc.nextLine();
        System.out.println("Enter the No of Books want to add: ");
        int noOfBooks = sc.nextInt();
        System.out.println("Enter the Tax for the book: ");
        float tax = sc.nextFloat();
        System.out.println("Enter the amount for the book:");
        float amount = sc.nextFloat();
        sc.nextLine();
        bookList.add(new Book(name, noOfBooks, amount, tax));
        return bookList;
    }

    // Display the book details that are available.
    @Override
    public void displayBooks(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book.getBookName() + " is available at "
        + book.getAmount() + "with tax " + book.getTax() + " % only");
        }
    }

    // Get the name, id, no of books needed input from the user.
    @Override
    public User getUserDetails(Scanner sc, String bookName,
            List<Book> bookList) {
        User e = new User();
        System.out.println("Enter your Details:");
        System.out.println("Enter your Name:");
        String name = sc.nextLine();
        System.out.println("Enter your Id:");
        int id = sc.nextInt();
        System.out.println("Enter no of books needed : ");
        int noOfBooks = sc.nextInt();
        sc.nextLine();
        e.setName(name);
        e.setId(id);
        for (Book l : bookList) {
            if (l.getBookName().equals(bookName)) {
                e.setBook(l);
                break;
            }
        }
        return e;
    }

    // Print the book details for the given user.
    @Override
    public void printBookDetails(User user) {
        float amount = user.getBook().getAmount();
        float taxPrice = user.getBook().getTax();
        float totalAmount = amount + taxPrice;
        int noOfBooks = user.getBook().getNoOfBooks();
        float finalAmount = totalAmount * noOfBooks;
        System.out.println("Your Book Details are\r\n" + " __________________"
                + "____________________" + "_______________\r\n" + "+ Hi "
                + user.getName() + "!!!! " + "\r\n" + "+ "
                        + " " + "" + " +\r\n"
                + "+ Your Selected Book Name is" + ": " + user.getBook()
                .getBookName() + "" + "+\r\n"
                + "+ You selected book price (for each)" + " : "
                + user.getBook().getAmount() + "+\r\n" + "+ " + " +\r\n"
                + "+ Your Book Amount for each (after tax) " + ": Rs. "
                + totalAmount + " +\r\n"
                + "+ Your Book Amount (after tax) : Rs. " + finalAmount + ""
                        + " +\r\n" + "+_______________________________"
                                + "_________"
                + "__________+");
    }

    /**
     * Update the Book details based upon the book name.
     */
    @Override
    public List<Book> updateBooks(Scanner sc, List<Book> bookList) {
        System.out.println("Enter Book Name:");
        String name = sc.nextLine();
        System.out.println("Enter the No of books want to add: ");
        int noOfBooks = sc.nextInt();
        System.out.println("Enter the amount for the Book: ");
        float amount = sc.nextFloat();
        System.out.println("Enter the Tax for the Book: ");
        float tax = sc.nextFloat();

        for (Book book : bookList) {
            if (book.getBookName().equals(name)) {
                bookList.remove(book);
                bookList.add(new Book(name, noOfBooks, amount, tax));
                break;
            }
        }

        return bookList;
    }

}