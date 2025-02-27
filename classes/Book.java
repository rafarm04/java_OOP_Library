package Library.classes;

import java.util.ArrayList;  
import java.util.List;  

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int quantity;

    //Constructor
    public Book(String title, String author, int quantity, String isbn){
        this.author = author;
        this.title = title;
        this.quantity = quantity;
        this.isbn = isbn;
    }

    //Getters
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public int getQuantity(){
        return quantity;
    }
    public String getISBN(){
        return isbn;
    }

    //Function
    public void displayBook(){
        System.out.println("Book: " + title + "\nAuthor: " + author + "\nISBN: " + isbn + "\tQuantity: " + quantity);
    }

    public void newQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void removeQuantity(int quantity) {
        this.quantity -= quantity;
    }

}
