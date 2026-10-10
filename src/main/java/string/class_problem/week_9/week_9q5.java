import java.util.*;

abstract class TravelBooking {

    static final double BOOKING_FEE = 50;

    double distance;

    TravelBooking(double distance) {
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    abstract String getType();

    double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class Bus extends TravelBooking {

    Bus(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return 2 * distance;
    }

    String getType() {
        return "BUS";
    }
}

class Train extends TravelBooking {

    Train(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return 1.5 * distance;
    }

    String getType() {
        return "TRAIN";
    }
}

class Flight extends TravelBooking {

    Flight(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return 2500 + (4 * distance);
    }

    String getType() {
        return "FLIGHT";
    }
}

public class week_9q5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();

            TravelBooking booking;

            if (type.equals("BUS")) {

                booking = new Bus(distance);

            } else if (type.equals("TRAIN")) {

                booking = new Train(distance);

            } else {

                booking = new Flight(distance);
            }

            double total = booking.calculateTotal();

            System.out.printf("%s: %.2f%n",
                    booking.getType(), total);
        }

        sc.close();
    }
}
