public class Main {
        public static void main(String[] args) {
            LibraryManagementSystem library = new LibraryManagementSystem();
    
            // Add new books
            library.addBook(new Book(1010, "Learn Java", "John Doe"));
            library.addBook(new Book(1011, "Learn Advanced Java", "Jane Doe"));
    
            // Display all books
            System.out.println("Library Books:");
            library.viewBooks();
    
            // Update the title of "Learn Advanced Java"
            library.updateBook(1011, "Learn Java: Advanced Topics", "Jane Doe");
    
            // Search for a book by title
            System.out.println("\nSearching for 'Learn Java':");
            Book foundBook = library.searchBookByTitle("Learn Java");
            System.out.println(foundBook != null ? foundBook : "Book not found.");
    
            // Delete the "Learn Java" book
            library.deleteBook(1010);
            System.out.println("\nAfter deleting 'Learn Java':");
            library.viewBooks();
        }
}
