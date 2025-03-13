package Library.classes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Librarian librarian = new Librarian();

        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. View Books");
            System.out.println("4. Search Book by Title, Author or ISBN");
            System.out.println("5. Register Patron");
            System.out.println("6. View Patrons");
            System.out.println("7. Check Out Book");
            System.out.println("8. Return Book");
            System.out.println("9. Books Per Patron");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1: // Add Book
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
                    System.out.println("Book added successfully.");
                    break;

                case 2: // Remove Book
                    System.out.print("Enter title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter quantity to remove: ");
                    quantity = scanner.nextInt();
                    librarian.removeBook(title, quantity);
                    break;

                case 3: // View Books
                    System.out.println("Books Available:");
                    librarian.displayBooks();
                    break;

                case 4: // Search Book
                    //In case of a skip, we assign an empty string
                    System.out.println("Enter title or press enter to skip: ");
                    String title_1 = scanner.nextLine();
                    title_1 = title_1.isEmpty() ? "" : title_1;

                    System.out.print("Enter author (or press Enter to skip): ");
                    String author_1 = scanner.nextLine();
                    author_1 = author_1.isEmpty() ? "" : author_1;

                    System.out.print("Enter ISBN (or press Enter to skip): ");
                    String isbn_1 = scanner.nextLine();
                    isbn_1 = isbn_1.isEmpty() ? "" : isbn_1;

                    Book foundBook = librarian.findBook(title_1, author_1, isbn_1);
                    if(foundBook != null){
                        System.out.println("Book Found:");
                        foundBook.displayBook();
                    }
                    break;

                case 5: // Register Patron
                    System.out.print("Enter patron name: ");
                    String patronName = scanner.nextLine();
                    System.out.print("Enter patron contact: ");
                    String patronContact = scanner.nextLine();
                    System.out.print("Enter patron ID: ");
                    int patronId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    librarian.regPatrons(patronName, patronContact, patronId);
                    System.out.println("Patron registered successfully.");
                    break;

                case 6: // View Patrons
                    System.out.println("Registered Patrons:");
                    librarian.viewPatrons();
                    break;

                case 7: // Check Out Book
                    System.out.print("Enter patron ID: ");
                    patronId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter book title: ");
                    title = scanner.nextLine();
                    librarian.checkOutBook(patronId, title);
                    break;

                case 8: // Return Book
                    System.out.print("Enter patron ID: ");
                    patronId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter book title: ");
                    title = scanner.nextLine();
                    librarian.returnBook(patronId, title);
                    break;

                case 9: // View Books Checked Out Per Patron
                    librarian.booksPerPatron();
                    break;

                case 10: // Exit
                    System.out.println("Exiting Library System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
