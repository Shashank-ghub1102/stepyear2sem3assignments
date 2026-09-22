package classesobjectsweek6.class_problems;

class Student {
    String name;
    int attendance;
    static String collegeName = "CodInClub College";
    static int studentCount;

    Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students on record: " + studentCount);
    }
}

public class Week6_ClassesObjects_CollegeInformation {
    public static void main(String[] args) {
        new Student("Ravi", 90);
        new Student("Meera", 95);
        Student.printCollegeInfo();
    }
}
