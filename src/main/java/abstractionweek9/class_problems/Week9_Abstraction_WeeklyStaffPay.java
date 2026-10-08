package abstractionweek9.class_problems;

import java.util.Scanner;

// Abstract base class representing a generic staff member
abstract class StaffMember {
    protected String name;

    public StaffMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method: each staff type has its own pay rule
    public abstract double calculatePay();
}

// Full-time staff paid a fixed weekly salary
class FullTimeStaff extends StaffMember {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

// Hourly staff paid by the hour with overtime (>40 hours at 1.5x)
class HourlyStaff extends StaffMember {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * 1.5 * rate);
        }
    }
}

// Interns paid a fixed stipend
class InternStaff extends StaffMember {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class Week9_Abstraction_WeeklyStaffPay {
    public static void processPayroll(StaffMember[] staff) {
        double totalPayroll = 0.0;
        for (StaffMember member : staff) {
            double pay = member.calculatePay();
            System.out.printf("%s: %.2f%n", member.getName(), pay);
            totalPayroll += pay;
        }
        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            StaffMember[] sampleStaff = {
                new FullTimeStaff("Asha", 12000),
                new HourlyStaff("Ravi", 45, 200),
                new InternStaff("Neha", 5000)
            };
            processPayroll(sampleStaff);
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        StaffMember[] staff = new StaffMember[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            if ("FULLTIME".equalsIgnoreCase(type)) {
                double salary = scanner.nextDouble();
                staff[i] = new FullTimeStaff(name, salary);
            } else if ("HOURLY".equalsIgnoreCase(type)) {
                double hours = scanner.nextDouble();
                double rate = scanner.nextDouble();
                staff[i] = new HourlyStaff(name, hours, rate);
            } else if ("INTERN".equalsIgnoreCase(type)) {
                double stipend = scanner.nextDouble();
                staff[i] = new InternStaff(name, stipend);
            }
        }

        processPayroll(staff);
        scanner.close();
    }
}
