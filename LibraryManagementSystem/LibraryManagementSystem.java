import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {

    private List<Book> books = new ArrayList<>();

    // Add a book
    public void addBook(Book book) {
        books.add(book);
    }

    // View all books
    public void viewBooks() {
        books.forEach(System.out::println);
    }

    // Update a book's details
    public void updateBook(int isbn, String newTitle, String newAuthor) {
        for (Book b : books) {
            if (b.getIsbn() == isbn) {
                b.setTitle(newTitle);
                b.setAuthor(newAuthor);
                break;
            }
        }
    }

    // Delete a book by ISBN
    public void deleteBook(int isbn) {
        books.removeIf(b -> b.getIsbn() == isbn);
    }

    // Search for a book by title
    public Book searchBookByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }      
}
