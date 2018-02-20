package LibraryShubhamMishra;

import java.util.HashMap;
import java.util.Objects;

public class Shelf {
    private int capacity = 1000;
    private HashMap<String, Book> bookMap = new HashMap<>();

    Book withdraw(Book book) {
        if(Objects.nonNull(book) && bookMap.containsKey(book.getIsbn())) {
            Book withDrawBook = bookMap.get(book.getIsbn());
            bookMap.remove(book.getIsbn());
            return withDrawBook;
        }
        return null;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public HashMap<String, Book> getBookMap() {
        return bookMap;
    }

    public void setBookMap(HashMap<String, Book> bookMap) {
        this.bookMap = bookMap;
    }

    @Override
    public String toString() {
        StringBuilder allBooks = new StringBuilder("Books = [ ");
        for (String s : bookMap.keySet()) {
            allBooks.append(s).append(" ");
        }
        allBooks.append(" ]");
        return allBooks.toString();
    }
}
