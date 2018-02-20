package LibraryShubhamMishra;

import static LibraryShubhamMishra.LibraryManagementSystem.*;

public class LibraryTest {


    public static void main(String[] args) {

        initialise();

        Book b1 = new Book("B1", "particle physics", 188, "Verma");
        Book b2 = new Book("B2", "thermodynamics", 2910, "Feynmann");
        Book b3 = new Book("B3", "algorithms", 1000, "Cormen");
        Book b4 = new Book("B4", "java", 2910, "bloch");

        returnBook(b1, 3);
        printShelves();

        returnBook(b2, 2);
        printShelves();

        withdrawBook(b2);
        printShelves();

        returnBook(b3, 7);
        printShelves();

        returnBook(b4, 7);
        printShelves();
    }
}
