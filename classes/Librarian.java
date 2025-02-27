package Library.classes;

import java.util.ArrayList;
import java.util.List;

public class Librarian {
    //Array of books in the library
    List<Book> books = new ArrayList<>();
    //Array of patrons
    List<Patron> patrons = new ArrayList<>();
     
    
    //Functions
    public void displayBooks(List<Book> books){
        for (Book book : books) {
            book.displayBook();
        }
    }

    public void addBook(String title, String author, int quantity, String isbn){
        for (Book book : books) {
            //If we find a book that's already in the list than just augment the quantity
            if(book.getTitle().equals(title)){
                book.newQuantity(quantity);
            }
            else{
                Book newBook = new Book(title, author, quantity, isbn);
                books.add(newBook);
                break;
            }
        }
    }

    public void removeBook(String title, String author, int quantity, String isbn){
        for (Book book : books) {
            //If we find a book that's already in the list 
            if(book.getTitle().equals(title)){
                //If the quantity of books that we want to remove is less or equal to the quantity of books we have than we remove them
                if(book.getQuantity() >= quantity){
                    book.removeQuantity(quantity);
                    if(book.getQuantity() == 0){
                        books.remove(book);
                    }
                    break;
                }
            }
        }
        //We didn't find the book
        System.out.println("The book doesn't exist or the quantity wanted to remove is a lot.");
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
}
