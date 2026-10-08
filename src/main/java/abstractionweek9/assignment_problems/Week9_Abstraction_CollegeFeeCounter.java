package abstractionweek9.assignment_problems;

import java.util.Scanner;

// Interface representing the ability/behavior to use the college bus
interface BusUser {
    double TRANSPORT_FEE = 12000.0;

    default double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

// Abstract base class representing a generic student
abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method: each student type has its specific tuition rule
    public abstract double calculateTuition();

    public double calculateTotalFee() {
        double fee = calculateTuition();
        if (this instanceof BusUser) {
            fee += ((BusUser) this).getTransportFee();
        }
        return fee;
    }
}

// Day scholar: tuition 40000, uses bus
class DayScholar extends Student implements BusUser {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0;
    }
}

// Hosteller: tuition 40000 + hostel fee 60000 = 100000, does not use bus
class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0 + 60000.0;
    }
}

// Scholarship student: half tuition 20000, uses bus
class ScholarshipStudent extends Student implements BusUser {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 20000.0;
    }
}

public class Week9_Abstraction_CollegeFeeCounter {
    public static void processFees(Student[] students) {
        double totalCollected = 0.0;
        for (Student student : students) {
            double fee = student.calculateTotalFee();
            System.out.printf("%s: %.2f%n", student.getName(), fee);
            totalCollected += fee;
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            Student[] sampleStudents = {
                new DayScholar("Asha"),
                new Hosteller("Ravi"),
                new ScholarshipStudent("Neha")
            };
            processFees(sampleStudents);
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            if ("DAY_SCHOLAR".equalsIgnoreCase(type)) {
                students[i] = new DayScholar(name);
            } else if ("HOSTELLER".equalsIgnoreCase(type)) {
                students[i] = new Hosteller(name);
            } else if ("SCHOLAR".equalsIgnoreCase(type)) {
                students[i] = new ScholarshipStudent(name);
            }
        }

        processFees(students);
        scanner.close();
    }
}
