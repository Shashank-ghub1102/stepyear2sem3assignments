package oop.class_problems;

class Student {
    String name;
    int marks;
}

public class Week3_OOP_SimpleStudentRecord {
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "Divya";
        student.marks = 88;
        System.out.println("Name: " + student.name + " | Marks: " + student.marks);
    }
}