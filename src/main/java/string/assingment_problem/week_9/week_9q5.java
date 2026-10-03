import java.util.*;

abstract class Appliance {
    protected double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    protected abstract double getPower();

    public double calculateUnits() {
        return (getPower() * hours) / 1000;
    }
}

interface SaverMode {
    double applySaver(double units);
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    protected double getPower() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    protected double getPower() {
        return 1500;
    }

    public double applySaver(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    protected double getPower() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    protected double getPower() {
        return 500;
    }

    public double applySaver(double units) {
        return units * 0.75;
    }
}

public class week_9q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext()) {
                String next = sc.nextLine().trim();
                saver = next.equals("SAVER");
            }

            Appliance appliance;

            if (type.equals("FRIDGE")) {
                appliance = new Fridge(hours);
            } else if (type.equals("AC")) {
                appliance = new AC(hours);
            } else if (type.equals("TV")) {
                appliance = new TV(hours);
            } else {
                appliance = new Washer(hours);
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits();

            if (saver) {
                units = ((SaverMode) appliance).applySaver(units);
            }

            double cost = units * 8;
            totalCost += cost;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}