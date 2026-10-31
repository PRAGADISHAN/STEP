import java.util.*;

class Book {
    String isbn;
    String title;
    Book(String isbn, String title) { this.isbn = isbn; this.title = title; }
}

public class LibraryCatalogLookup {
    public static String findBook(Book[] catalog, String targetIsbn) {
        int l = 0, r = catalog.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cmp = catalog[mid].isbn.compareTo(targetIsbn);
            if (cmp == 0) return catalog[mid].title;
            else if (cmp < 0) l = mid + 1;
            else r = mid - 1;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        Book[] catalog = {
            new Book("0001112223", "Introduction to Algebra"),
            new Book("0002223334", "Beginning Python"),
            new Book("0003334445", "Classic Mythology"),
            new Book("0004445556", "Data and Society"),
            new Book("0005556667", "European History")
        };
        System.out.println(findBook(catalog, "0003334445")); // Classic Mythology
        System.out.println(findBook(catalog, "0009998887")); // Not Found
    }
}
