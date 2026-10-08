package polymorphismweek8.assignment_problems;

import java.util.Scanner;

abstract class Student {
    protected String name;
    public static final double TRANSPORT_FEE = 12000.0;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateTuition();

    public double calculateTotalFee() {
        double fee = calculateTuition();
        if (this instanceof UsesBus) {
            fee += TRANSPORT_FEE;
        }
        return fee;
    }
}

interface UsesBus {
}

class DayScholarStudent extends Student implements UsesBus {
    public DayScholarStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0;
    }
}

class HostellerStudent extends Student {
    public HostellerStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        // Tuition 40000 plus hostel fee 60000
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends Student implements UsesBus {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        // Half of normal tuition (20000)
        return 20000.0;
    }
}

public class Week8_Polymorphism_CollegeFeeCounter {
    public static void processStudents(Student[] students) {
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
                new DayScholarStudent("Asha"),
                new HostellerStudent("Ravi"),
                new ScholarshipStudent("Neha")
            };
            processStudents(sampleStudents);
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            if ("DAY_SCHOLAR".equalsIgnoreCase(type)) {
                students[i] = new DayScholarStudent(name);
            } else if ("HOSTELLER".equalsIgnoreCase(type)) {
                students[i] = new HostellerStudent(name);
            } else if ("SCHOLAR".equalsIgnoreCase(type)) {
                students[i] = new ScholarshipStudent(name);
            }
        }

        processStudents(students);
        scanner.close();
    }
}
