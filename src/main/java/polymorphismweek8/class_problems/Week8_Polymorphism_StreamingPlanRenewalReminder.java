package polymorphismweek8.class_problems;

import java.time.LocalDate;
import java.util.Scanner;

abstract class StreamingPlan {
    protected String subscriberName;
    protected LocalDate startDate;

    public StreamingPlan(String subscriberName, LocalDate startDate) {
        this.subscriberName = subscriberName;
        this.startDate = startDate;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public abstract int getValidityDays();

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends StreamingPlan {
    public BasicPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends StreamingPlan {
    public StandardPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends StreamingPlan {
    public PremiumPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public int getValidityDays() {
        return 365;
    }
}

public class Week8_Polymorphism_StreamingPlanRenewalReminder {
    public static void processRenewals(StreamingPlan[] plans) {
        for (StreamingPlan plan : plans) {
            LocalDate renewalDate = plan.calculateRenewalDate();
            System.out.println(plan.getSubscriberName() + ": " + renewalDate);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            StreamingPlan[] samplePlans = {
                new BasicPlan("Asha", LocalDate.parse("2024-01-15")),
                new StandardPlan("Ravi", LocalDate.parse("2024-02-01")),
                new PremiumPlan("Neha", LocalDate.parse("2024-03-10")),
                new BasicPlan("Kiran", LocalDate.parse("2024-12-20"))
            };
            processRenewals(samplePlans);
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        StreamingPlan[] plans = new StreamingPlan[n];
        for (int i = 0; i < n; i++) {
            String planType = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();
            LocalDate startDate = LocalDate.parse(dateStr);

            if ("BASIC".equalsIgnoreCase(planType)) {
                plans[i] = new BasicPlan(name, startDate);
            } else if ("STANDARD".equalsIgnoreCase(planType)) {
                plans[i] = new StandardPlan(name, startDate);
            } else if ("PREMIUM".equalsIgnoreCase(planType)) {
                plans[i] = new PremiumPlan(name, startDate);
            }
        }

        processRenewals(plans);
        scanner.close();
    }
}
