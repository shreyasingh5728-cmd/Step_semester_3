import java.util.*;

abstract class Ticket {
    private static final double CONVENIENCE_FEE = 20.0;

    protected int count;

    Ticket(int count) {
        this.count = count;
    }

    protected abstract double getPrice();

    public double calculateAmount() {
        return count * (getPrice() + CONVENIENCE_FEE);
    }
}

class Regular extends Ticket {
    Regular(int count) {
        super(count);
    }

    protected double getPrice() {
        return 150.0;
    }
}

class Premium extends Ticket {
    Premium(int count) {
        super(count);
    }

    protected double getPrice() {
        return 250.0;
    }
}

class Recliner extends Ticket {
    Recliner(int count) {
        super(count);
    }

    protected double getPrice() {
        return 400.0;
    }
}

public class week_9q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        Map<String, java.util.function.Function<Integer, Ticket>> tickets = new HashMap<>();

        tickets.put("REGULAR", Regular::new);
        tickets.put("PREMIUM", Premium::new);
        tickets.put("RECLINER", Recliner::new);

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            Ticket ticket = tickets.get(seat).apply(count);
            double amount = ticket.calculateAmount();

            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
