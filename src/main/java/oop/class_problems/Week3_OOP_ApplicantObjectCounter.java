package oop.class_problems;

class Applicant {
    static int totalApplicants;

    Applicant() {
        totalApplicants++;
    }
}

public class Week3_OOP_ApplicantObjectCounter {
    public static void main(String[] args) {
        new Applicant();
        new Applicant();
        new Applicant();
        System.out.println("Total applicants: " + Applicant.totalApplicants);
    }
}