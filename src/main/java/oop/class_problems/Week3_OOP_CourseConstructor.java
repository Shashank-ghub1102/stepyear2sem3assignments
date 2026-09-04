package oop.class_problems;

class Course {
    String code;
    String title;

    Course(String code, String title) {
        this.code = code;
        this.title = title;
    }
}

public class Week3_OOP_CourseConstructor {
    public static void main(String[] args) {
        Course course = new Course("21CSC201J", "Data Structures");
        System.out.println(course.code + " - " + course.title);
    }
}