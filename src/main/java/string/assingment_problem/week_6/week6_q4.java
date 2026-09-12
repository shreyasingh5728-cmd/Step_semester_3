public class week6_q4 {

    String studentName;
    int seatNumber;

    // Constructor
    public week6_q4(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {

        // Create Priya's HallTicket object
        week6_q4 priya = new week6_q4("Priya", 0);

        // copy points to the same object
        week6_q4 copy = priya;

        // Change seat number using copy
        copy.seatNumber = 45;

        // Create a separate object
        week6_q4 separate = new week6_q4("Priya", 45);

        System.out.println("Priya's seatNumber (via first variable):");
        System.out.println(priya.seatNumber);

        System.out.println("copy == priya: " + (copy == priya));

        System.out.println("separate == priya: " + (separate == priya));
    }
}
