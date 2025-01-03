import java.util.Scanner;

public class Book {
    private int ISBN;
    private String bookTitle;
    private int numberOfPages;
    private static int count = 0;

    // Default constructor
    public Book() {
        count++;
    }

    // Parameterized constructor
    public Book(int ISBN, String bookTitle, int numberOfPages) {
        this.ISBN = ISBN;
        this.bookTitle = bookTitle;
        this.numberOfPages = numberOfPages;
        count++;
    }

    // Getters and setters
    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    // toString method
    public String toString() {
        String str = "ISBN: " + this.ISBN + "\n";
        str += "Book Title: " + this.bookTitle + "\n";
        str += "Number of Pages: " + this.numberOfPages + "\n";
        str += "-----------------------------------\n";
        return str;
    }

    // compareTo method
    public int compareTo(Book otherBook) {
        if (this.numberOfPages > otherBook.numberOfPages) {
            return 1;
        } else if (this.numberOfPages == otherBook.numberOfPages) {
            return 0;
        } else {
            return -1;
        }
    }

    // Static method to get the count of books
    public static int getCount() {
        return count;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of Book objects
        System.out.println("Enter the number of books to create:");
        int n = sc.nextInt();
        sc.nextLine();

        Book[] books = new Book[n];

        // Input for each Book object
        for (int i = 0; i < books.length; ++i) {
            books[i] = new Book();
            System.out.println("Book " + (i + 1));
            System.out.print("Enter ISBN: ");
            books[i].setISBN(sc.nextInt());
            sc.nextLine(); // Consume the newline
            System.out.print("Enter Book Title: ");
            books[i].setBookTitle(sc.nextLine());
            System.out.print("Enter Number of Pages: ");
            books[i].setNumberOfPages(sc.nextInt());
            sc.nextLine(); // Consume the newline
        }

        // Display all books
        System.out.println("\nDisplaying all books:");
        for (Book book : books) {
            System.out.println(book.toString());
        }

        // Compare two books
        System.out.println("Enter the indices of two books to compare (0 to " + (n - 1) + "):");
        int index1 = sc.nextInt();
        int index2 = sc.nextInt();
        int comparison = books[index1].compareTo(books[index2]);
        System.out.println("Comparison result: " + comparison);

        // Check if a book is "heavier"
        System.out.println("Enter the index of a book to check if it's heavier:");
        int index3 = sc.nextInt();
        boolean isHeavier = isHeavier(books[index3]);
        System.out.println("Is the book heavier than 500 pages? " + isHeavier);

        // Search for books by title
        sc.nextLine(); // Consume the newline
        System.out.println("Enter a book title to search:");
        String titleSearch = sc.nextLine();
        searchByTitle(books, titleSearch);

        // Close the scanner
        sc.close();
    }

    // Static method to check if a book is heavier than 500 pages
    public static boolean isHeavier(Book book) {
        return book.getNumberOfPages() > 500;
    }

    // Static method to search books by title
    public static void searchByTitle(Book[] books, String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getBookTitle().equalsIgnoreCase(title)) {
                System.out.println(book.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with the title: " + title);
        }
    }
}