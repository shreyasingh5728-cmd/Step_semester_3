public class week6_q5 {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor
    public week6_q5(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    // Static method
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {

        week6_q5 employee1 = new week6_q5("Divya", 65000);

        week6_q5 employee2 = new week6_q5("Arjun", 50000);

        week6_q5 employee3 = new week6_q5("Priya", 55000);

        System.out.println("3 Employee objects created");

        week6_q5.printCompanyInfo();
    }
}
