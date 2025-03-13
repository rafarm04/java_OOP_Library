package Library.classes;

import java.util.ArrayList;
import java.util.List;

public class Librarian {
    //Array of books in the library
    List<Book> books = new ArrayList<>();
    //Array of patrons
    List<Patron> patrons = new ArrayList<>();
     
    
    //Functions
    public void displayBooks(){
        for (Book book : books) {
            book.displayBook();
        }
    }

    public void addBook(String title, String author, int quantity, String isbn) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.newQuantity(quantity); // If book exists, update quantity
                return;
            }
        }
        books.add(new Book(title, author, quantity, isbn)); // If book doesn't exist, add it
    }


    public void removeBook(String title, int quantity) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                if (book.getQuantity() >= quantity) {
                    book.removeQuantity(quantity);
                    if (book.getQuantity() == 0) {
                        books.remove(book);
                    }
                    return; // Exit after removing the book
                } else {
                    System.out.println("Not enough books available.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }


    public void editBook(String title, String newTitle, String newAuthor, int newQuantity, String newIsbn) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                book.setQuantity(newQuantity);
                book.setISBN(newIsbn);
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public Book findBook(String... optionalParams) { // Fixed parameter name
        String title = optionalParams.length > 0 ? optionalParams[0] : null;
        String author = optionalParams.length > 1 ? optionalParams[1] : null;
        String isbn = optionalParams.length > 2 ? optionalParams[2] : null;

        for (Book book : books) {
            if ((title != null && book.getTitle().equals(title)) ||
                (author != null && book.getAuthor().equals(author)) ||
                (isbn != null && book.getISBN().equals(isbn))) {
                return book;
            }
        }
        return null;
    }

    public Patron findPatronById(int id) {
        for (Patron patron : patrons) {
            if (patron.getId() == id) {
                return patron;
            }
        }
        return null;
    }

    public void checkOutBook(int patronId, String bookTitle) {
        Patron patron = findPatronById(patronId);
        Book book = findBook(bookTitle);

        if (patron == null) {
            System.out.println("Patron not found.");
            return;
        }
        if (book == null || book.getQuantity() == 0) {
            System.out.println("Book not available.");
            return;
        }

        // Reduce book quantity and add it to patron's list
        book.removeQuantity(1);
        patron.checkOutBook(book);
        System.out.println(patron.getName() + " checked out " + book.getTitle());
    }

    public void returnBook(int patronId, String bookTitle) {
        Patron patron = findPatronById(patronId);
        if (patron == null) {
            System.out.println("Patron not found.");
            return;
        }

        Book bookToReturn = null;
        for (Book book : patron.getBorrowedBooks()) {  // Check patron's books
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                bookToReturn = book;
                break;
            }
        }

        if (bookToReturn == null) {
            System.out.println("Patron did not borrow this book.");
            return;
        }

        Book libraryBook = findBook(bookTitle);
        if (libraryBook == null) {
            System.out.println("Error: Book does not exist in library records.");
            return;
        }

        libraryBook.newQuantity(1);
        patron.returnBook(bookToReturn);
        System.out.println(patron.getName() + " returned " + bookTitle);
    }


    public void regPatrons(String name, String contact, int id){
        Patron newPatron = new Patron(name, contact, id);
        patrons.add(newPatron);
    }

    public void viewPatrons(){
        for (Patron patron : patrons) {
            patron.displayPatron();
        }
    }

    public void editPatron(int id, String newName, String newContact) {
        for (Patron patron : patrons) {
            if (patron.getId() == id) {
                patron.setName(newName);
                patron.setContact(newContact);
                System.out.println("Patron updated successfully.");
                return;
            }
        }
        System.out.println("Patron not found.");
    }

    public void booksPerPatron() {
        if (patrons.isEmpty()) {
            System.out.println("No registered patrons.");
            return;
        }

        System.out.println("\n===== Books Checked Out Per Patron =====");
        for (Patron patron : patrons) {
            System.out.println("Patron: " + patron.getName() + " (ID: " + patron.getId() + ")");
            
            List<Book> borrowedBooks = patron.getBorrowedBooks();
            if (borrowedBooks.isEmpty()) {
                System.out.println("   No books checked out.");
            } else {
                for (Book book : borrowedBooks) {
                    System.out.println("   - " + book.getTitle() + " by " + book.getAuthor());
                }
            }
        }
    }
}
