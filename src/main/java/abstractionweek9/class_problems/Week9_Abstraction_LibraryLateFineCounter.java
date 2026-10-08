package abstractionweek9.class_problems;

import java.util.Scanner;

// Abstract base class representing a library item
abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public int getDaysLate() {
        return daysLate;
    }

    // Abstract method: each item type calculates its late fine differently
    public abstract double calculateFine();
}

// Book: 2 per day late
class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

// DVD: 5 per day late, up to a maximum of 50
class DvdItem extends LibraryItem {
    public DvdItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return Math.min(50.0, daysLate * 5.0);
    }
}

// Magazine: 1 per day late
class MagazineItem extends LibraryItem {
    public MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class Week9_Abstraction_LibraryLateFineCounter {
    public static void processFines(LibraryItem[] items) {
        double totalFines = 0.0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            System.out.printf("%s: %.2f%n", item.getTitle(), fine);
            totalFines += fine;
        }
        System.out.printf("Total Fines: %.2f%n", totalFines);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            LibraryItem[] sampleItems = {
                new BookItem("Algebra", 4),
                new DvdItem("Inception", 12),
                new MagazineItem("Sports", 3)
            };
            processFines(sampleItems);
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        LibraryItem[] items = new LibraryItem[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();
            if ("BOOK".equalsIgnoreCase(type)) {
                items[i] = new BookItem(title, daysLate);
            } else if ("DVD".equalsIgnoreCase(type)) {
                items[i] = new DvdItem(title, daysLate);
            } else if ("MAGAZINE".equalsIgnoreCase(type)) {
                items[i] = new MagazineItem(title, daysLate);
            }
        }

        processFines(items);
        scanner.close();
    }
}
