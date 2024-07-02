import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LibraryManagementSystem {
    private HashMap<String, Boolean> books;
    private Scanner scanner;

    public LibraryManagementSystem() {
        books = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        library.run();
    }

    public void run() {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    issueBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    viewBooks();
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add Book");
        System.out.println("2. Issue Book");
        System.out.println("3. Return Book");
        System.out.println("4. View Books");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private void addBook() {
        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();
        books.put(title, true); // true indicates the book is available
        System.out.println("Book added to the library.");
    }

    private void issueBook() {
        System.out.print("Enter the title of the book to issue: ");
        String title = scanner.nextLine();
        if (books.containsKey(title) && books.get(title)) {
            books.put(title, false); // false indicates the book is issued
            System.out.println("Book issued.");
        } else {
            System.out.println("Book is either not available or already issued.");
        }
    }

    private void returnBook() {
        System.out.print("Enter the title of the book to return: ");
        String title = scanner.nextLine();
        if (books.containsKey(title) && !books.get(title)) {
            books.put(title, true); // true indicates the book is available
            System.out.println("Book returned.");
        } else {
            System.out.println("Book is either not recognized or not issued.");
        }
    }

    private void viewBooks() {
        System.out.println("\nLibrary Books:");
        for (String title : books.keySet()) {
            String status = books.get(title) ? "Available" : "Issued";
            System.out.println(title + " - " + status);
        }
    }
}
