// Exercise 6: Library Management System

import java.util.*;

// Step 2: Book class setup
class Book implements Comparable<Book> {
    String bookId;
    String title;
    String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }

    @Override
    public String toString() {
        return "BookID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

public class LibraryManagement {

    // Step 3: Linear Search Implementation
    public static Book linearSearch(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }

    // Step 3: Binary Search Implementation (sorted array required)
    public static Book binarySearch(Book[] books, String targetTitle) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(targetTitle);
            if (cmp == 0)
                return books[mid];
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        // Step 2: Setup
        Book[] books = {
                new Book("B001", "The Hobbit", "J.R.R. Tolkien"),
                new Book("B002", "1984", "George Orwell"),
                new Book("B003", "To Kill a Mockingbird", "Harper Lee"),
                new Book("B004", "The Catcher in the Rye", "J.D. Salinger"),
                new Book("B005", "Moby-Dick", "Herman Melville")
        };

        // Linear Search
        System.out.println("--- Linear Search ---");
        Book found1 = linearSearch(books, "1984");
        System.out.println(found1 != null ? found1 : "Book not found.");

        // Sort array for binary search
        Arrays.sort(books);

        // Binary Search
        System.out.println("\n--- Binary Search ---");
        Book found2 = binarySearch(books, "1984");
        System.out.println(found2 != null ? found2 : "Book not found.");
    }
}