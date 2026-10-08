package abstractionweek9.assignment_problems;

import java.util.Scanner;

// Interface representing the insurable capability
interface Insurable {
    double calculateInsurance();
}

// Abstract base class representing a generic parcel
abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;
    protected String type;

    public Parcel(String type, double weightKg, double declaredValue) {
        this.type = type;
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public String getType() {
        return type;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public double getDeclaredValue() {
        return declaredValue;
    }

    // Abstract method: every parcel calculates shipping charge
    public abstract double calculateShippingCharge();

    public double getInsurance() {
        if (this instanceof Insurable) {
            return ((Insurable) this).calculateInsurance();
        }
        return 0.0;
    }

    public double calculateTotal() {
        return calculateShippingCharge() + getInsurance();
    }
}

// Standard parcel: 40 + 10 per kg, not insurable
class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super("STANDARD", weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 40.0 + (10.0 * weightKg);
    }
}

// Express parcel: 80 + 15 per kg, insurable (2% of declared value)
class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) {
        super("EXPRESS", weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 80.0 + (15.0 * weightKg);
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }
}

// Fragile parcel: standard charge + 50 handling fee, insurable (2% of declared value)
class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) {
        super("FRAGILE", weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return (40.0 + (10.0 * weightKg)) + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }
}

public class Week9_Abstraction_ParcelShippingDesk {
    public static void processParcels(Parcel[] parcels) {
        double grandTotal = 0.0;
        for (Parcel parcel : parcels) {
            double charge = parcel.calculateShippingCharge();
            double insurance = parcel.getInsurance();
            double total = parcel.calculateTotal();
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.getType(), charge, insurance, total);
            grandTotal += total;
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            Parcel[] sampleParcels = {
                new StandardParcel(3, 500),
                new ExpressParcel(2, 1000),
                new FragileParcel(4, 2000)
            };
            processParcels(sampleParcels);
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        Parcel[] parcels = new Parcel[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double value = scanner.nextDouble();
            if ("STANDARD".equalsIgnoreCase(type)) {
                parcels[i] = new StandardParcel(weight, value);
            } else if ("EXPRESS".equalsIgnoreCase(type)) {
                parcels[i] = new ExpressParcel(weight, value);
            } else if ("FRAGILE".equalsIgnoreCase(type)) {
                parcels[i] = new FragileParcel(weight, value);
            }
        }

        processParcels(parcels);
        scanner.close();
    }
}
