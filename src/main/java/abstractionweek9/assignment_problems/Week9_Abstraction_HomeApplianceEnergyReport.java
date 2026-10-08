package abstractionweek9.assignment_problems;

import java.util.Scanner;

// Interface representing the ability to operate in saver mode
interface EnergySaverCapable {
    default double applySaverReduction(double baseUnits) {
        return baseUnits * 0.75; // 25% reduction
    }
}

// Abstract base class representing a generic home appliance
abstract class Appliance {
    protected double hours;

    public Appliance(double hours) {
        this.hours = hours;
    }

    public abstract double getPowerWatts();
    public abstract String getApplianceName();

    public double calculateBaseUnits() {
        return (getPowerWatts() * hours) / 1000.0;
    }

    public double calculateUnits(boolean saverMode) throws UnsupportedOperationException {
        double baseUnits = calculateBaseUnits();
        if (saverMode) {
            if (!(this instanceof EnergySaverCapable)) {
                throw new UnsupportedOperationException("saver mode not supported");
            }
            return ((EnergySaverCapable) this).applySaverReduction(baseUnits);
        }
        return baseUnits;
    }

    public double calculateCost(double units) {
        return units * 8.0;
    }
}

class FridgeAppliance extends Appliance {
    public FridgeAppliance(double hours) {
        super(hours);
    }

    @Override
    public double getPowerWatts() {
        return 150.0;
    }

    @Override
    public String getApplianceName() {
        return "FRIDGE";
    }
}

class AcAppliance extends Appliance implements EnergySaverCapable {
    public AcAppliance(double hours) {
        super(hours);
    }

    @Override
    public double getPowerWatts() {
        return 1500.0;
    }

    @Override
    public String getApplianceName() {
        return "AC";
    }
}

class TvAppliance extends Appliance {
    public TvAppliance(double hours) {
        super(hours);
    }

    @Override
    public double getPowerWatts() {
        return 100.0;
    }

    @Override
    public String getApplianceName() {
        return "TV";
    }
}

class WasherAppliance extends Appliance implements EnergySaverCapable {
    public WasherAppliance(double hours) {
        super(hours);
    }

    @Override
    public double getPowerWatts() {
        return 500.0;
    }

    @Override
    public String getApplianceName() {
        return "WASHER";
    }
}

public class Week9_Abstraction_HomeApplianceEnergyReport {
    static class ApplianceRequest {
        Appliance appliance;
        boolean saverMode;

        ApplianceRequest(Appliance appliance, boolean saverMode) {
            this.appliance = appliance;
            this.saverMode = saverMode;
        }
    }

    public static void generateReport(ApplianceRequest[] requests) {
        double totalCost = 0.0;
        for (ApplianceRequest req : requests) {
            try {
                double units = req.appliance.calculateUnits(req.saverMode);
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
                new ApplianceRequest(new FridgeAppliance(24), false),
                new ApplianceRequest(new AcAppliance(8), true),
                new ApplianceRequest(new TvAppliance(5), false),
                new ApplianceRequest(new WasherAppliance(2), true)
            };
            generateReport(sampleRequests);
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        ApplianceRequest[] requests = new ApplianceRequest[n];
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            double hours = scanner.nextDouble();
            String restOfLine = scanner.nextLine().trim();
            boolean saver = "SAVER".equalsIgnoreCase(restOfLine);

            Appliance app = null;
            if ("FRIDGE".equalsIgnoreCase(name)) {
                app = new FridgeAppliance(hours);
            } else if ("AC".equalsIgnoreCase(name)) {
                app = new AcAppliance(hours);
            } else if ("TV".equalsIgnoreCase(name)) {
                app = new TvAppliance(hours);
            } else if ("WASHER".equalsIgnoreCase(name)) {
                app = new WasherAppliance(hours);
            }
            requests[i] = new ApplianceRequest(app, saver);
        }

        generateReport(requests);
        scanner.close();
    }
}
