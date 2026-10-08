package polymorphismweek8.class_problems;

import java.util.Scanner;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();

    public abstract String getTransportName();
}

class BusTransport extends Transport {
    public BusTransport(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0);
    }

    @Override
    public String getTransportName() {
        return "BUS";
    }
}

class TrainTransport extends Transport {
    public TrainTransport(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }

    @Override
    public String getTransportName() {
        return "TRAIN";
    }
}

class MetroTransport extends Transport {
    private double peakHourFactor;

    public MetroTransport(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    @Override
    public String getTransportName() {
        return "METRO";
    }
}

public class Week8_Polymorphism_PublicTransportFareCalculator {
    public static void processFares(Transport[] journeys) {
        double grandTotal = 0.0;
        for (Transport journey : journeys) {
            double fare = journey.calculateFare();
            System.out.printf("%s: %.2f%n", journey.getTransportName(), fare);
            grandTotal += fare;
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            Transport[] sampleJourneys = {
                new BusTransport(15),
                new TrainTransport(50),
                new MetroTransport(10, 1.5)
            };
            processFares(sampleJourneys);
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        Transport[] journeys = new Transport[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();
            if ("BUS".equalsIgnoreCase(type)) {
                journeys[i] = new BusTransport(distance);
            } else if ("TRAIN".equalsIgnoreCase(type)) {
                journeys[i] = new TrainTransport(distance);
            } else if ("METRO".equalsIgnoreCase(type)) {
                double peakHourFactor = scanner.nextDouble();
                journeys[i] = new MetroTransport(distance, peakHourFactor);
            }
        }

        processFares(journeys);
        scanner.close();
    }
}
