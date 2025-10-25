// File: Main.java

public class Main {
    public static void main(String[] args) {
        // 1. Create a library instance
        Library myLibrary = new Library();

        // 2. Add some books to the library
        myLibrary.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien"));
        myLibrary.addBook(new Book("Pride and Prejudice", "Jane Austen"));
        myLibrary.addBook(new Book("1984", "George Orwell"));

        // 3. Add some users
        myLibrary.addUser(new User("Alice"));
        myLibrary.addUser(new User("Bob"));

        // 4. Show initial state of available books
        System.out.println("Welcome to the Library Management System!");
        myLibrary.displayAvailableBooks();

        // 5. Simulate book issuing
        System.out.println("--- Issuing books ---");

        
        myLibrary.issueBook("1984", "Alice");
        myLibrary.issueBook("Dune", "Bob"); // This book doesn't exist
        
        // 6. Show available books after issuing one
        myLibrary.displayAvailableBooks();

        // 7. Simulate book returning
        System.out.println("--- Returning books ---");
        myLibrary.returnBook("1984", "Alice");
        myLibrary.returnBook("Pride and Prejudice", "Bob"); // Bob never borrowed this
        
        // 8. Show final state of available books
        myLibrary.displayAvailableBooks();
    }
}