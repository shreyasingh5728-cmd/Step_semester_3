import java.util.*;

abstract class Student {
    protected String name;

    Student(String name) {
        this.name = name;
    }

    protected abstract double calculateTuition();

    protected double getTransportFee() {
        return 0;
    }

    public double calculateFee() {
        return calculateTuition() + getTransportFee();
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    protected double calculateTuition() {
        return 40000;
    }

    protected double getTransportFee() {
        return 12000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    protected double calculateTuition() {
        return 40000 + 60000;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    protected double calculateTuition() {
        return 20000;
    }

    protected double getTransportFee() {
        return 12000;
    }
}

public class week_9q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student;

            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else {
                student = new Scholar(name);
            }

            double fee = student.calculateFee();

            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
    }
}
