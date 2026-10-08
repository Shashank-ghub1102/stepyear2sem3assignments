package polymorphismweek8.class_problems;

import java.util.Scanner;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();

    public abstract String getPaymentTypeName();
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + (amount * 0.02);
    }

    @Override
    public String getPaymentTypeName() {
        return "CARD";
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + (amount * 0.01);
    }

    @Override
    public String getPaymentTypeName() {
        return "WALLET";
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount;
    }

    @Override
    public String getPaymentTypeName() {
        return "BANKTRANSFER";
    }
}

public class Week8_Polymorphism_PaymentSystemFeeCalculation {
    public static void processPayments(Payment[] payments) {
        double total = 0.0;
        for (Payment payment : payments) {
            double finalAmount = payment.calculateFinalAmount();
            System.out.printf("%s: %.2f%n", payment.getPaymentTypeName(), finalAmount);
            total += finalAmount;
        }
        System.out.printf("Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            Payment[] samplePayments = {
                new CardPayment(1000),
                new WalletPayment(500),
                new BankTransferPayment(2000)
            };
            processPayments(samplePayments);
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        Payment[] payments = new Payment[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            if ("CARD".equalsIgnoreCase(type)) {
                payments[i] = new CardPayment(amount);
            } else if ("WALLET".equalsIgnoreCase(type)) {
                payments[i] = new WalletPayment(amount);
            } else if ("BANKTRANSFER".equalsIgnoreCase(type)) {
                payments[i] = new BankTransferPayment(amount);
            }
        }

        processPayments(payments);
        scanner.close();
    }
}
