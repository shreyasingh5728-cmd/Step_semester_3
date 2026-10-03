import java.util.*;

interface Employee {
    double calculateBonus();
}

class FullTime implements Employee {
    private double salary;

    FullTime(double salary) {
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTime implements Employee {
    private double salary;

    PartTime(double salary) {
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern implements Employee {
    public double calculateBonus() {
        return 2000;
    }
}

public class week_8q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        Map<String, java.util.function.Function<Double, Employee>> employees = new HashMap<>();

        employees.put("FULLTIME", salary -> new FullTime(salary));
        employees.put("PARTTIME", salary -> new PartTime(salary));
        employees.put("INTERN", salary -> new Intern());

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee = employees.get(type).apply(salary);
            double bonus = employee.calculateBonus();

            System.out.printf("%s: %.2f%n", name, bonus);
            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
