package LibraryShubhamMishra;

public class Book {

    private String isbn;
    private String name;
    private int price;
    private String author;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        Book other = (Book) obj;
        return this.author.equalsIgnoreCase(other.author) &&
                this.isbn.equalsIgnoreCase(other.isbn) &&
                this.name.equalsIgnoreCase(other.name) &&
                this.price == other.price;
    }

    public Book(String isbn, String name, int price, String author) {
        this.isbn = isbn;
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    public String getAuthor() {
        return author;
    }


}
