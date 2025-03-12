package Library.classes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Librarian librarian = new Librarian();
        
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Find Book by Title");
            System.out.println("5. Register Patron");
            System.out.println("6. View Patrons");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    librarian.addBook(title, author, quantity, isbn);
                    System.out.println("Book added successfully!");
                    break;
                
                case 2:
                    System.out.print("Enter title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    author = scanner.nextLine();
                    System.out.print("Enter quantity to remove: ");
                    quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter ISBN: ");
                    isbn = scanner.nextLine();
                    librarian.removeBook(title, author, quantity, isbn);
                    break;
                
                case 3:
                    librarian.displayBooks();
                    break;
                
                case 4:
                    System.out.print("Enter title to search: ");
                    title = scanner.nextLine();
                    Book foundBook = librarian.findBookByTitle(title);
                    if (foundBook != null) {
                        foundBook.displayBook();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                
                case 5:
                    System.out.print("Enter patron name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    librarian.regPatrons(name, contact, id);
                    System.out.println("Patron registered successfully!");
                    break;
                
                case 6:
                    librarian.viewPatrons();
                    break;
                
                case 7:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}