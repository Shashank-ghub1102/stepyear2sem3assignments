package abstractionweek9.assignment_problems;

import java.util.Scanner;

// Abstract base class representing a movie ticket
abstract class Ticket {
    protected int count;
    // Shared convenience fee defined in one place only
    public static final double CONVENIENCE_FEE = 20.0;

    public Ticket(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    // Abstract methods enforced on all concrete ticket types
    public abstract double getPricePerTicket();
    public abstract String getSeatType();

    public double calculateTotalAmount() {
        return count * (getPricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    public double getPricePerTicket() {
        return 150.0;
    }

    @Override
    public String getSeatType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    public double getPricePerTicket() {
        return 250.0;
    }

    @Override
    public String getSeatType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    public double getPricePerTicket() {
        return 400.0;
    }

    @Override
    public String getSeatType() {
        return "RECLINER";
    }
}

public class Week9_Abstraction_MovieTicketCounter {
    public static void processBookings(Ticket[] bookings) {
        double total = 0.0;
        for (Ticket booking : bookings) {
            double amount = booking.calculateTotalAmount();
            System.out.printf("%s: %.2f%n", booking.getSeatType(), amount);
            total += amount;
        }
        System.out.printf("Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            Ticket[] sampleBookings = {
                new RegularTicket(3),
                new PremiumTicket(2),
                new ReclinerTicket(1)
            };
            processBookings(sampleBookings);
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        Ticket[] bookings = new Ticket[n];
        for (int i = 0; i < n; i++) {
            String seat = scanner.next();
            int count = scanner.nextInt();
            if ("REGULAR".equalsIgnoreCase(seat)) {
                bookings[i] = new RegularTicket(count);
            } else if ("PREMIUM".equalsIgnoreCase(seat)) {
                bookings[i] = new PremiumTicket(count);
            } else if ("RECLINER".equalsIgnoreCase(seat)) {
                bookings[i] = new ReclinerTicket(count);
            }
        }

        processBookings(bookings);
        scanner.close();
    }
}
