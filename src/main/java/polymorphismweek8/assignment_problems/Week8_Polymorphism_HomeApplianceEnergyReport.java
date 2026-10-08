package polymorphismweek8.assignment_problems;

import java.util.Scanner;

abstract class Appliance {
    protected double hours;

    public Appliance(double hours) {
        this.hours = hours;
    }

    public abstract double getPowerRating();

    public abstract String getApplianceName();

    public double calculateStandardUnits() {
        return (getPowerRating() * hours) / 1000.0;
    }

    public double calculateUnits(boolean saverMode) throws UnsupportedOperationException {
        if (saverMode) {
            if (!(this instanceof EnergySaverSupported)) {
                throw new UnsupportedOperationException("saver mode not supported");
            }
            return ((EnergySaverSupported) this).calculateSaverUnits(hours);
        }
        return calculateStandardUnits();
    }

    public double calculateCost(double units) {
        return units * 8.0;
    }
}

interface EnergySaverSupported {
    default double calculateSaverUnits(double hours) {
        // 25% reduction = 75% of regular units
        Appliance app = (Appliance) this;
        return (app.getPowerRating() * hours / 1000.0) * 0.75;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours) {
        super(hours);
    }

    @Override
    public double getPowerRating() {
        return 150.0;
    }

    @Override
    public String getApplianceName() {
        return "FRIDGE";
    }
}

class AirConditioner extends Appliance implements EnergySaverSupported {
    public AirConditioner(double hours) {
        super(hours);
    }

    @Override
    public double getPowerRating() {
        return 1500.0;
    }

    @Override
    public String getApplianceName() {
        return "AC";
    }
}

class Television extends Appliance {
    public Television(double hours) {
        super(hours);
    }

    @Override
    public double getPowerRating() {
        return 100.0;
    }

    @Override
    public String getApplianceName() {
        return "TV";
    }
}

class WashingMachine extends Appliance implements EnergySaverSupported {
    public WashingMachine(double hours) {
        super(hours);
    }

    @Override
    public double getPowerRating() {
        return 500.0;
    }

    @Override
    public String getApplianceName() {
        return "WASHER";
    }
}

class ApplianceRequest {
    Appliance appliance;
    boolean isSaver;

    ApplianceRequest(Appliance appliance, boolean isSaver) {
        this.appliance = appliance;
        this.isSaver = isSaver;
    }
}

public class Week8_Polymorphism_HomeApplianceEnergyReport {
    public static void generateReport(ApplianceRequest[] requests) {
        double totalCost = 0.0;
        for (ApplianceRequest req : requests) {
            try {
                double units = req.appliance.calculateUnits(req.isSaver);
                double cost = req.appliance.calculateCost(units);
                System.out.printf("%s: Units=%.2f Cost=%.2f%n",
                        req.appliance.getApplianceName(), units, cost);
                totalCost += cost;
            } catch (UnsupportedOperationException e) {
                System.out.printf("%s: %s%n",
                        req.appliance.getApplianceName(), e.getMessage());
            }
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            ApplianceRequest[] sampleRequests = {
                new ApplianceRequest(new Fridge(24), false),
                new ApplianceRequest(new AirConditioner(8), true),
                new ApplianceRequest(new Television(5), false),
                new ApplianceRequest(new WashingMachine(2), true)
            };
            generateReport(sampleRequests);
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        ApplianceRequest[] requests = new ApplianceRequest[n];
        for (int i = 0; i < n; i++) {
            String appType = scanner.next();
            double hours = scanner.nextDouble();
            boolean isSaver = false;
            String restOfLine = scanner.nextLine().trim();
            if (restOfLine.contains("SAVER")) {
                isSaver = true;
            }

            Appliance appliance = null;
            if ("FRIDGE".equalsIgnoreCase(appType)) {
                appliance = new Fridge(hours);
            } else if ("AC".equalsIgnoreCase(appType)) {
                appliance = new AirConditioner(hours);
            } else if ("TV".equalsIgnoreCase(appType)) {
                appliance = new Television(hours);
            } else if ("WASHER".equalsIgnoreCase(appType)) {
                appliance = new WashingMachine(hours);
            }
            requests[i] = new ApplianceRequest(appliance, isSaver);
        }

        generateReport(requests);
        scanner.close();
    }
}
