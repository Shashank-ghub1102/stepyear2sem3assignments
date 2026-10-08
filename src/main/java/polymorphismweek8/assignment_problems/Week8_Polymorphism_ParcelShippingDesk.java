package polymorphismweek8.assignment_problems;

import java.util.Scanner;

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateShippingCharge();

    public abstract String getParcelType();

    public double calculateInsurance() {
        if (this instanceof Insurable) {
            return ((Insurable) this).calculateInsurance();
        }
        return 0.0;
    }

    public double calculateTotal() {
        return calculateShippingCharge() + calculateInsurance();
    }
}

interface Insurable {
    double calculateInsurance();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 40.0 + (10.0 * weightKg);
    }

    @Override
    public String getParcelType() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 80.0 + (15.0 * weightKg);
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }

    @Override
    public String getParcelType() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return (40.0 + (10.0 * weightKg)) + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }

    @Override
    public String getParcelType() {
        return "FRAGILE";
    }
}

public class Week8_Polymorphism_ParcelShippingDesk {
    public static void processParcels(Parcel[] parcels) {
        double grandTotal = 0.0;
        for (Parcel parcel : parcels) {
            double charge = parcel.calculateShippingCharge();
            double insurance = parcel.calculateInsurance();
            double total = parcel.calculateTotal();
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.getParcelType(), charge, insurance, total);
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
            double declaredValue = scanner.nextDouble();
            if ("STANDARD".equalsIgnoreCase(type)) {
                parcels[i] = new StandardParcel(weight, declaredValue);
            } else if ("EXPRESS".equalsIgnoreCase(type)) {
                parcels[i] = new ExpressParcel(weight, declaredValue);
            } else if ("FRAGILE".equalsIgnoreCase(type)) {
                parcels[i] = new FragileParcel(weight, declaredValue);
            }
        }

        processParcels(parcels);
        scanner.close();
    }
}
