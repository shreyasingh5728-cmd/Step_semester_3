import java.util.*;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    public double calculateCharge() {
        return 40 + (10 * weight);
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    public double calculateCharge() {
        return 80 + (15 * weight);
    }

    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    public double calculateCharge() {
        return 40 + (10 * weight) + 50;
    }

    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

public class week_9q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            Parcel parcel;

            if (type.equals("STANDARD")) {
                parcel = new StandardParcel(weight, declaredValue);
            } else if (type.equals("EXPRESS")) {
                parcel = new ExpressParcel(weight, declaredValue);
            } else {
                parcel = new FragileParcel(weight, declaredValue);
            }

            double charge = parcel.calculateCharge();
            double insurance = 0;

            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel)
                        .calculateInsurance(declaredValue);
            }

            double total = charge + insurance;
            grandTotal += total;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}
