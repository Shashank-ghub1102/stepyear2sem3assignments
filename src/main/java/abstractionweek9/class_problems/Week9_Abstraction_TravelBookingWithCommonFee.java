package abstractionweek9.class_problems;

import java.util.Scanner;

// Abstract base class handling the common booking fee and delegating base fare calculation
abstract class TravelBooking {
    // Shared booking fee defined in one place only
    public static final double BOOKING_FEE = 50.0;

    protected String mode;
    protected double distanceKm;

    public TravelBooking(String mode, double distanceKm) {
        this.mode = mode;
        this.distanceKm = distanceKm;
    }

    public String getMode() {
        return mode;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    // Abstract method: each travel mode calculates its base fare uniquely
    public abstract double calculateBaseFare();

    // Final/concrete template method applying the shared booking fee
    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

// Bus booking: 2 per km
class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super("BUS", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 2.0;
    }
}

// Train booking: 1.5 per km
class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super("TRAIN", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 1.5;
    }
}

// Flight booking: 2500 plus 4 per km
class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super("FLIGHT", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + (distanceKm * 4.0);
    }
}

public class Week9_Abstraction_TravelBookingWithCommonFee {
    public static void processBookings(TravelBooking[] bookings) {
        for (TravelBooking booking : bookings) {
            double totalFare = booking.calculateTotalFare();
            System.out.printf("%s: %.2f%n", booking.getMode(), totalFare);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            TravelBooking[] sampleBookings = {
                new BusBooking(200),
                new TrainBooking(300),
                new FlightBooking(500)
            };
            processBookings(sampleBookings);
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        TravelBooking[] bookings = new TravelBooking[n];
        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distanceKm = scanner.nextDouble();
            if ("BUS".equalsIgnoreCase(mode)) {
                bookings[i] = new BusBooking(distanceKm);
            } else if ("TRAIN".equalsIgnoreCase(mode)) {
                bookings[i] = new TrainBooking(distanceKm);
            } else if ("FLIGHT".equalsIgnoreCase(mode)) {
                bookings[i] = new FlightBooking(distanceKm);
            }
        }

        processBookings(bookings);
        scanner.close();
    }
}
