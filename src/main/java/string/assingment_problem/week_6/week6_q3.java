public class week6_q3 {

    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Constructor for permanent employee
    public week6_q3(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor for intern
    public week6_q3(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    // Print profile
    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {

        week6_q3 employee1 = new week6_q3("E-101", "Divya", 65000);

        week6_q3 employee2 = new week6_q3("E-102", "Arjun");

        employee1.printProfile();
        employee2.printProfile();
    }
}
