package Library.classes;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private int id;
    private String contact; //email
    private List<Book> borrowedBooks; //List for borrowed books

    public Patron(String name, String contact, int id){
        this.name = name;
        this.id = id;
        this.contact = contact;
        this.borrowedBooks = new ArrayList<>();
    }

    //getters
    public String getContact() {
        return contact;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List getBorrowedBooks(){
        return borrowedBooks;
    }

    //setters
    public void setContact(String cont){
        this.contact = cont;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
    
    //functions
    public void displayPatron(){
        System.out.println("Name: " + name + "\tID: " + id + "\nContact: " + contact);
    }

    public void checkOutBook(Book book) {
        borrowedBooks.add(book); 
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book); 
    }


    public void printCheckedOutBooks() {
        if (checkedOutBooks.isEmpty()) {
            System.out.println(name + " has no checked-out books.");
        } else {
            System.out.println(name + "'s Checked Out Books:");
            for (Book book : checkedOutBooks) {
                book.displayBook();
            }
        }
    }
}
