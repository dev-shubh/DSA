package LibraryShubhamMishra;

import java.util.Objects;

public class LibraryManagementSystem {

    private static int shelvesLimit = 10;
    private static Shelf[] shelves = new Shelf[shelvesLimit];


    synchronized static void initialise() {
        for(int i = 0; i < getShelvesLimit(); i++) {
            getShelves()[i] = new Shelf();
        }
    }

    synchronized static void returnBook(Book book, int shelfNo) {

        if(shelfNo >= shelvesLimit || shelfNo < 0) {
            throw new RuntimeException("Invalid Shelf");
        }
        else {
            Shelf shelf = shelves[shelfNo];
            if ( shelf.getBookMap().size() > shelf.getCapacity() ) {
                throw new RuntimeException("Given Shelf is out of capacity, please select another shelf");
            }
            else {
                shelf.getBookMap().put(book.getIsbn(), book);
            }
        }

    }

    synchronized static Book withdrawBook(Book book) {

        for (int i = 0; i < shelves.length; i++) {
            Book requiredBook = shelves[i].withdraw(book);
            if(Objects.nonNull(requiredBook)) {
                return requiredBook;
            }
        }
        return null;

    }

    static void printShelves(){
        for(int i=0; i<shelvesLimit; i++) {
            System.out.println( "shelf = " + i + "   " + shelves[i].toString());
        }
        System.out.println("-------------------");
    }


    static Shelf[] getShelves() {
        return shelves;
    }

    public static void setShelves(Shelf[] shelves) {
        LibraryManagementSystem.shelves = shelves;
    }

    static int getShelvesLimit() {
        return shelvesLimit;
    }

    public static void setShelvesLimit(int shelvesLimit) {
        LibraryManagementSystem.shelvesLimit = shelvesLimit;
    }

}
