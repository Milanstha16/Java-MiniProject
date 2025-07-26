import java.util.*;

class Book {
    private final String title;
    private final String author;
    private final String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() { return title; }

    public String getAuthor() { return author; }

    public String getIsbn() { return isbn; }

    @Override
    public String toString() {
        return "[Title: " + title + ", Author: " + author + ", ISBN: " + isbn + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book b)) return false;
        return isbn.equals(b.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {

        List<Book> allBooks = new ArrayList<>();
        System.out.println();
        allBooks.add(new Book("Java Programming", "Ashish Gautam", "001"));
        allBooks.add(new Book("Operating System", "Saroj Ghimire", "002"));
        allBooks.add(new Book("Computer Network", "Dipak Adhikari", "003"));

        Set<Book> borrowedBooks = new HashSet<>();

        Map<String, List<Book>> memberBorrowMap = new HashMap<>();

        String memberId = "M001";
        List<Book> borrowedByMember = new ArrayList<>();
        borrowedByMember.add(allBooks.get(0));  
        borrowedByMember.add(allBooks.get(2));  

        borrowedBooks.addAll(borrowedByMember);
        memberBorrowMap.put(memberId, borrowedByMember);

        System.out.println("All Books in Library:");
        for (Book b : allBooks) {
            System.out.println(b);
        }

        System.out.println("\nBorrowed Books:");
        Iterator<Book> it = borrowedBooks.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nBorrowed Books by Member (ID: " + memberId + "):");
        displayBorrowedBooks(memberBorrowMap.get(memberId));
    }

    private static void displayBorrowedBooks(List<? extends Book> books) {
        for (Book b : books) {
            System.out.println("- " + b.getTitle() + " by " + b.getAuthor());
        }
    }
}
