package polymorphismweek8.class_problems;

import java.util.Scanner;

abstract class Delivery {
    protected double weight;
    protected double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();

    public abstract String getDeliveryTypeName();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }

    @Override
    public String getDeliveryTypeName() {
        return "STANDARD";
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 15.0 + (1.00 * weight) + (0.20 * distance);
    }

    @Override
    public String getDeliveryTypeName() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }

    @Override
    public String getDeliveryTypeName() {
        return "INTERNATIONAL";
    }
}

public class Week8_Polymorphism_DeliveryFeeCalculator {
    public static void processDeliveries(Delivery[] deliveries) {
        double total = 0.0;
        for (Delivery delivery : deliveries) {
            double fee = delivery.calculateFee();
            System.out.printf("%s: %.2f%n", delivery.getDeliveryTypeName(), fee);
            total += fee;
        }
        System.out.printf("Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            Delivery[] sampleDeliveries = {
                new StandardDelivery(10, 50),
                new ExpressDelivery(5, 20),
                new InternationalDelivery(20, 100, 30)
            };
            processDeliveries(sampleDeliveries);
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        Delivery[] deliveries = new Delivery[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();
            if ("STANDARD".equalsIgnoreCase(type)) {
                deliveries[i] = new StandardDelivery(weight, distance);
            } else if ("EXPRESS".equalsIgnoreCase(type)) {
                deliveries[i] = new ExpressDelivery(weight, distance);
            } else if ("INTERNATIONAL".equalsIgnoreCase(type)) {
                double customsFee = scanner.nextDouble();
                deliveries[i] = new InternationalDelivery(weight, distance, customsFee);
            }
        }

        processDeliveries(deliveries);
        scanner.close();
    }
}
