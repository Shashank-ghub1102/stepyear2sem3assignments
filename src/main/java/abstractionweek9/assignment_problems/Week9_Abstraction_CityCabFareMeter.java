package abstractionweek9.assignment_problems;

import java.util.Scanner;

// Interface representing the capability to provide night service
interface NightServiceable {
    default double calculateNightFare(double baseFare) {
        return baseFare * 1.20;
    }
}

// Abstract base class representing a generic cab
abstract class Cab {
    protected double km;

    public Cab(double km) {
        this.km = km;
    }

    public abstract double getRatePerKm();
    public abstract String getCabType();

    // Shared business rule: minimum fare of 100
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

class SuvCab extends Cab implements NightServiceable {
    public SuvCab(double km) {
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

public class Week9_Abstraction_CityCabFareMeter {
    static class TripRequest {
        Cab cab;
        boolean isNight;

        TripRequest(Cab cab, boolean isNight) {
            this.cab = cab;
            this.isNight = isNight;
        }
    }

    public static void processTrips(TripRequest[] trips) {
        double total = 0.0;
        for (TripRequest trip : trips) {
            try {
                double fare = trip.cab.calculateTripFare(trip.isNight);
                System.out.printf("%s: %.2f%n", trip.cab.getCabType(), fare);
                total += fare;
            } catch (UnsupportedOperationException e) {
                System.out.printf("%s: %s%n", trip.cab.getCabType(), e.getMessage());
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            TripRequest[] sampleTrips = {
                new TripRequest(new MiniCab(8), false),
                new TripRequest(new SedanCab(10), true),
                new TripRequest(new SuvCab(20), false),
                new TripRequest(new MiniCab(5), true)
            };
            processTrips(sampleTrips);
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        TripRequest[] trips = new TripRequest[n];
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
                cab = new SuvCab(km);
            }
            trips[i] = new TripRequest(cab, isNight);
        }

        processTrips(trips);
        scanner.close();
    }
}
