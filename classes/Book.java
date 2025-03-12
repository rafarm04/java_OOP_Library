package Library.classes;

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

    //Setters
    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setQuantity(int quant){
        this.quantity = quant;
    }

    public void setISBN(String isbn){
        this.isbn = isbn;
    }

    //Functions
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
