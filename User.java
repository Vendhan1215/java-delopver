// File: User.java

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Book> borrowedBooks;

    // Constructor
    public User(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Method for a user to borrow a book
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // Method for a user to return a book
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    // --- Getters ---
    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}