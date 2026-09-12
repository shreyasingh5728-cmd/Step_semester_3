public class week6_q2 {
    private double basicSalary;
    private double bonus;

    // Constructor
    public week6_q2(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Negative salary. Starting with Rs 0.0");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }

        this.bonus = 0;
    }

    // Credit bonus
    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid bonus amount.");
        } else {
            bonus = bonus + amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    // Deduct tax
    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percentage.");
        } else {
            basicSalary = basicSalary - (basicSalary * percent / 100);
            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    // Get net salary
    public double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {

        week6_q2 payroll = new week6_q2(50000);

        payroll.creditBonus(5000);

        payroll.deductTax(10);

        System.out.println("Net salary: Rs " + payroll.getNetSalary());
    }
}
    

