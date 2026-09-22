package classesobjectsweek6.class_problems;

class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord() {
        System.out.println(studentName + " | " + company + " | " + packageLpa + " LPA");
    }
}

public class Week6_ClassesObjects_PlacementRecord {
    public static void main(String[] args) {
        new PlacementRecord("Ananya", "TechNova", 8.5).printRecord();
    }
}
