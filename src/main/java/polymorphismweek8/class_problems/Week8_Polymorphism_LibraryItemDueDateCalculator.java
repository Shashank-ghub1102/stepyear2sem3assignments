package polymorphismweek8.class_problems;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract LocalDate calculateDueDate(LocalDate currentDate);
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14);
    }
}

class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7);
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3);
    }
}

public class Week8_Polymorphism_LibraryItemDueDateCalculator {
    public static void processItems(LibraryItem[] items, LocalDate currentDate) {
        for (LibraryItem item : items) {
            LocalDate dueDate = item.calculateDueDate(currentDate);
            System.out.println(item.getTitle() + ": " + dueDate);
        }
    }

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            LibraryItem[] sampleItems = {
                new Book("1984"),
                new DVD("The Matrix"),
                new Magazine("Forbes Issue 500")
            };
            processItems(sampleItems, currentDate);
            scanner.close();
            return;
        }

        String firstLine = scanner.nextLine().trim();
        if (firstLine.isEmpty()) {
            LibraryItem[] sampleItems = {
                new Book("1984"),
                new DVD("The Matrix"),
                new Magazine("Forbes Issue 500")
            };
            processItems(sampleItems, currentDate);
            scanner.close();
            return;
        }

        int n;
        try {
            n = Integer.parseInt(firstLine);
        } catch (NumberFormatException e) {
            n = 0;
        }

        LibraryItem[] items = new LibraryItem[n];
        Pattern pattern = Pattern.compile("^([A-Z]+)\\s+\"?(.*?)\"?$");

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String type = matcher.group(1);
                String title = matcher.group(2);
                if (title.endsWith("\"")) {
                    title = title.substring(0, title.length() - 1);
                }

                if ("BOOK".equalsIgnoreCase(type)) {
                    items[i] = new Book(title);
                } else if ("DVD".equalsIgnoreCase(type)) {
                    items[i] = new DVD(title);
                } else if ("MAGAZINE".equalsIgnoreCase(type)) {
                    items[i] = new Magazine(title);
                }
            }
        }

        processItems(items, currentDate);
        scanner.close();
    }
}
