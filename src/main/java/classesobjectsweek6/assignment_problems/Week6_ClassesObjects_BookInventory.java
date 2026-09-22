package classesobjectsweek6.assignment_problems;

class BookInventory {
    String title;
    String author;
    int copiesAvailable;

    BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry() {
        System.out.println(title + " | " + author + " | Copies: " + copiesAvailable);
    }
}

public class Week6_ClassesObjects_BookInventory {
    public static void main(String[] args) {
        BookInventory[] books = {
                new BookInventory("The Alchemist", "Paulo Coelho", 4),
                new BookInventory("1984", "George Orwell", 3),
                new BookInventory("Wings of Fire", "A. P. J. Abdul Kalam", 5),
                new BookInventory("Sapiens", "Yuval Noah Harari", 2)
        };
        for (BookInventory book : books) {
            book.printEntry();
        }
    }
}
