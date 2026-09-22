package classesobjectsweek6.assignment_problems;

class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Basic salary cannot be negative. Starting at 0.");
            basicSalary = 0;
        }
        this.basicSalary = basicSalary;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: amount must be positive");
            return;
        }
        bonus += amount;
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax rejected: percent must be between 0 and 100");
            return;
        }
        basicSalary -= basicSalary * percent / 100;
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class Week6_ClassesObjects_PayrollAccount {
    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: " + account.getNetSalary());
    }
}
