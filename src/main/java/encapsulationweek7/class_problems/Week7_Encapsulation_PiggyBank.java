package encapsulationweek7.class_problems;

class PiggyBank {
    private double savings;

    public void deposit(double amount) {
        if (amount > 0) savings += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= savings) savings -= amount;
    }

    public double getSavings() {
        return savings;
    }
}

public class Week7_Encapsulation_PiggyBank {
    public static void main(String[] args) {
        PiggyBank bank = new PiggyBank();
        bank.deposit(200);
        bank.withdraw(50);
        System.out.println("Savings: " + bank.getSavings());
    }
}
