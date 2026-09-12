public class week6_q1 {

    private double basicSalary;
    private double bonus;

    public week6_q1(double basicSalary) {
        if (basicSalary < 0) {
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }

        this.bonus = 0;
    }

    public static void main(String[] args) {

        week6_q1 p = new week6_q1(-5000);

        System.out.println(p.basicSalary);
        System.out.println(p.bonus);
    }
}
    

