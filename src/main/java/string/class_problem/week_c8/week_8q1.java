import java.util.*;

interface PaymentMethod {
    double calculateFinalAmount(double amount);
    String getType();
}

class Card implements PaymentMethod {
    public double calculateFinalAmount(double amount) {
        return amount + (amount * 0.02);
    }

    public String getType() {
        return "CARD";
    }
}

class Wallet implements PaymentMethod {
    public double calculateFinalAmount(double amount) {
        return amount + (amount * 0.01);
    }

    public String getType() {
        return "WALLET";
    }
}

class BankTransfer implements PaymentMethod {
    public double calculateFinalAmount(double amount) {
        return amount;
    }

    public String getType() {
        return "BANKTRANSFER";
    }
}

class Transaction {
    PaymentMethod paymentMethod;
    double amount;

    Transaction(PaymentMethod paymentMethod, double amount) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    double getFinalAmount() {
        return paymentMethod.calculateFinalAmount(amount);
    }
}

public class week_8q1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            PaymentMethod paymentMethod;

            if (type.equals("CARD")) {
                paymentMethod = new Card();
            } else if (type.equals("WALLET")) {
                paymentMethod = new Wallet();
            } else {
                paymentMethod = new BankTransfer();
            }

            Transaction transaction =
                    new Transaction(paymentMethod, amount);

            double adjustedAmount = transaction.getFinalAmount();

            System.out.printf("%s: %.2f%n",
                    paymentMethod.getType(), adjustedAmount);

            total += adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}