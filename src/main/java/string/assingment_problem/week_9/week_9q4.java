import java.util.*;

abstract class Cab {
    protected static final double MINIMUM_FARE = 100.0;
    protected double km;

    Cab(double km) {
        this.km = km;
    }

    protected abstract double getRate();

    public double calculateFare() {
        double fare = km * getRate();

        if (fare < MINIMUM_FARE) {
            fare = MINIMUM_FARE;
        }

        return fare;
    }
}

interface NightService {
    double applyNightCharge(double fare);
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    protected double getRate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    protected double getRate() {
        return 14;
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    protected double getRate() {
        return 18;
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

public class week_9q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI")) {
                cab = new Mini(km);
            } else if (type.equals("SEDAN")) {
                cab = new Sedan(km);
            } else {
                cab = new SUV(km);
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")) {
                fare = ((NightService) cab).applyNightCharge(fare);
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}