package polymorphismweek8.assignment_problems;

import java.util.Scanner;

abstract class Cab {
    protected double km;

    public Cab(double km) {
        this.km = km;
    }

    public abstract double getRatePerKm();

    public abstract String getCabType();

    public double calculateBaseFare() {
        return Math.max(100.0, km * getRatePerKm());
    }

    public double calculateTripFare(boolean isNight) throws UnsupportedOperationException {
        if (isNight) {
            if (!(this instanceof NightServiceable)) {
                throw new UnsupportedOperationException("night service not available");
            }
            return ((NightServiceable) this).calculateNightFare(calculateBaseFare());
        }
        return calculateBaseFare();
    }
}

interface NightServiceable {
    default double calculateNightFare(double baseFare) {
        return baseFare * 1.20;
    }
}

class MiniCab extends Cab {
    public MiniCab(double km) {
        super(km);
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }

    @Override
    public String getCabType() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double km) {
        super(km);
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }

    @Override
    public String getCabType() {
        return "SEDAN";
    }
}

class SUVCab extends Cab implements NightServiceable {
    public SUVCab(double km) {
        super(km);
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }

    @Override
    public String getCabType() {
        return "SUV";
    }
}

class TripBooking {
    Cab cab;
    boolean isNight;

    TripBooking(Cab cab, boolean isNight) {
        this.cab = cab;
        this.isNight = isNight;
    }
}

public class Week8_Polymorphism_CityCabFareMeter {
    public static void processBookings(TripBooking[] bookings) {
        double grandTotal = 0.0;
        for (TripBooking booking : bookings) {
            try {
                double fare = booking.cab.calculateTripFare(booking.isNight);
                System.out.printf("%s: %.2f%n", booking.cab.getCabType(), fare);
                grandTotal += fare;
            } catch (UnsupportedOperationException e) {
                System.out.printf("%s: %s%n", booking.cab.getCabType(), e.getMessage());
            }
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            TripBooking[] sampleBookings = {
                new TripBooking(new MiniCab(8), false),
                new TripBooking(new SedanCab(10), true),
                new TripBooking(new SUVCab(20), false),
                new TripBooking(new MiniCab(5), true)
            };
            processBookings(sampleBookings);
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        TripBooking[] bookings = new TripBooking[n];
        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();
            boolean isNight = "NIGHT".equalsIgnoreCase(time);

            Cab cab = null;
            if ("MINI".equalsIgnoreCase(cabType)) {
                cab = new MiniCab(km);
            } else if ("SEDAN".equalsIgnoreCase(cabType)) {
                cab = new SedanCab(km);
            } else if ("SUV".equalsIgnoreCase(cabType)) {
                cab = new SUVCab(km);
            }
            bookings[i] = new TripBooking(cab, isNight);
        }

        processBookings(bookings);
        scanner.close();
    }
}
