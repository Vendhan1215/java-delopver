// File: Book.java

public class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor to initialize a Book object
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // A new book is always available
    }

    // --- Getters ---
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // --- Setters ---
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}