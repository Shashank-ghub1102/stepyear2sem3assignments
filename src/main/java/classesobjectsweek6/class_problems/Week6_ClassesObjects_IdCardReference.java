package classesobjectsweek6.class_problems;

class IdCard {
    String name;
    int booksIssued;

    IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class Week6_ClassesObjects_IdCardReference {
    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard copy = ravi;
        copy.booksIssued = 3;
        IdCard separate = new IdCard("Ravi", 3);
        System.out.println("Ravi's booksIssued: " + ravi.booksIssued);
        System.out.println("copy == ravi: " + (copy == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
