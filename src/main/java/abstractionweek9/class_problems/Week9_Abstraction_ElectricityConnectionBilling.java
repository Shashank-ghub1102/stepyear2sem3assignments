package abstractionweek9.class_problems;

import java.util.Scanner;

// Abstract base class representing an electricity connection
abstract class ElectricityConnection {
    protected double units;
    protected String type;

    public ElectricityConnection(String type, double units) {
        this.type = type;
        this.units = units;
    }

    public String getType() {
        return type;
    }

    public double getUnits() {
        return units;
    }

    // Abstract method: each connection type has its own tariff formula
    public abstract double calculateBill();
}

// Home connection: 5 per unit for first 100 units, 7 per unit above 100
class HomeConnection extends ElectricityConnection {
    public HomeConnection(double units) {
        super("HOME", units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100.0 * 5.0) + ((units - 100.0) * 7.0);
        }
    }
}

// Shop connection: 8 per unit plus fixed charge of 100
class ShopConnection extends ElectricityConnection {
    public ShopConnection(double units) {
        super("SHOP", units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

// Factory connection: 6 per unit with a minimum bill of 1000
class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(double units) {
        super("FACTORY", units);
    }

    @Override
    public double calculateBill() {
        return Math.max(1000.0, units * 6.0);
    }
}

public class Week9_Abstraction_ElectricityConnectionBilling {
    public static void generateBillSummary(ElectricityConnection[] connections) {
        double totalBill = 0.0;
        for (ElectricityConnection conn : connections) {
            double bill = conn.calculateBill();
            System.out.printf("%s: %.2f%n", conn.getType(), bill);
            totalBill += bill;
        }
        System.out.printf("Total: %.2f%n", totalBill);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            ElectricityConnection[] sampleConnections = {
                new HomeConnection(150),
                new ShopConnection(90),
                new FactoryConnection(120)
            };
            generateBillSummary(sampleConnections);
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        ElectricityConnection[] connections = new ElectricityConnection[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double units = scanner.nextDouble();
            if ("HOME".equalsIgnoreCase(type)) {
                connections[i] = new HomeConnection(units);
            } else if ("SHOP".equalsIgnoreCase(type)) {
                connections[i] = new ShopConnection(units);
            } else if ("FACTORY".equalsIgnoreCase(type)) {
                connections[i] = new FactoryConnection(units);
            }
        }

        generateBillSummary(connections);
        scanner.close();
    }
}
