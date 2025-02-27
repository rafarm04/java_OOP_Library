package Library.classes;

public class Patron {
    private String name;
    private int id;
    private String contact; //email

    public Patron(String name, String contact, int id){
        this.name = name;
        this.id = id;
        this.contact = contact;
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
    
    //functions
    public void displayPatron(){
        System.out.println("Name: " + name + "\tID: " + id + "\nContact: " + contact);
    }
}
