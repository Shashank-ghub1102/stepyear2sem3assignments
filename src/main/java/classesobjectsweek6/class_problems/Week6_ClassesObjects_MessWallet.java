package classesobjectsweek6.class_problems;

class MessWallet {
    private double balance;

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Opening balance cannot be negative. Starting at 0.");
            openingBalance = 0;
        }
        balance = openingBalance;
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be positive");
            return;
        }
        balance += amount;
    }

    public void deduct(double amount) {
        if (amount <= 0 || amount > balance) {
            System.out.println("Deduct rejected: insufficient balance or invalid amount");
            return;
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

public class Week6_ClassesObjects_MessWallet {
    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
