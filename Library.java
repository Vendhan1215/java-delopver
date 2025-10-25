// File: Library.java

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // --- Book Management ---
    public void addBook(Book book) {
        books.add(book);
    }

    // --- User Management ---
    public void addUser(User user) {
        users.add(user);
    }

    // --- Core Features: Issue and Return Books ---

    /**
     * Issues a book to a user.
     * Checks if the book exists, the user exists, and the book is available.
     */
    public void issueBook(String bookTitle, String userName) {
        Book foundBook = null;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle) && book.isAvailable()) {
                foundBook = book;
                break;
            }
        }

        User foundUser = null;
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(userName)) {
                foundUser = user;
                break;
            }
        }

        if (foundBook != null && foundUser != null) {
            foundBook.setAvailable(false); // Mark the book as unavailable
            foundUser.borrowBook(foundBook);
            System.out.println("✅ Success: '" + bookTitle + "' has been issued to " + userName + ".");
        } else if (foundBook == null) {
            System.out.println("❌ Error: Book '" + bookTitle + "' not found or is currently unavailable.");
        } else {
            System.out.println("❌ Error: User '" + userName + "' not found.");
        }
    }

    /**
     * Returns a book from a user.
     */
    public void returnBook(String bookTitle, String userName) {
         Book foundBook = null;
         User foundUser = null;

         // Find the user first
         for (User user : users) {
             if (user.getName().equalsIgnoreCase(userName)) {
                 foundUser = user;
                 break;
             }
         }

         if(foundUser == null) {
            System.out.println("❌ Error: User '" + userName + "' not found.");
            return;
         }

         // Check if the user has borrowed this book
         for (Book book : foundUser.getBorrowedBooks()) {
             if(book.getTitle().equalsIgnoreCase(bookTitle)) {
                 foundBook = book;
                 break;
             }
         }

         if(foundBook != null) {
             foundBook.setAvailable(true); // Mark the book as available again
             foundUser.returnBook(foundBook);
             System.out.println("✅ Success: '" + bookTitle + "' has been returned by " + userName + ".");
         } else {
            System.out.println("❌ Error: " + userName + " did not borrow the book '" + bookTitle + "'.");
         }
    }

    /**
     * Displays all books that are currently available.
     */
    public void displayAvailableBooks() {
        System.out.println("\n--- Available Books ---");
        boolean anyAvailable = false;
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(" - " + book.getTitle() + " by " + book.getAuthor());
                anyAvailable = true;
            }
        }
        if(!anyAvailable){
            System.out.println("No books are currently available.");
        }
        System.out.println("-----------------------\n");
    }
}