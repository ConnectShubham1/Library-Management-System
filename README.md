# Library-Management-System
A system to manage library operations such as issuing books, returning books, and keeping track of books.
# Library Management System

## Description

A system to manage library operations such as issuing books, returning books, and keeping track of books.

## How to Run

1. **Clone the repository**:
    ```
    git clone https://github.com/yourusername/LibraryManagementSystem.git
    cd LibraryManagementSystem
    ```

2. **Compile the Java file**:
    ```
    javac src/LibraryManagementSystem.java
    ```

3. **Run the Java file**:
    ```
    java -cp src LibraryManagementSystem
    ```

## Example Code

```java
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
        System.out
