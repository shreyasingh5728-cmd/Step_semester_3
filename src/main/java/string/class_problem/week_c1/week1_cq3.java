import java.util.*;

public class week1_cq3 {

    static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } 
        else if (bmi < 25) {
            return "Normal";
        } 
        else if (bmi < 30) {
            return "Overweight";
        } 
        else {
            return "Obese";
        }
    }

    static void printWellnessReport(double[] heights, double[] weights) {

        System.out.println(
            "Person | Height (m) | Weight (kg) | BMI | Status"
        );

        for (int i = 0; i < heights.length; i++) {

            double bmi = weights[i] / (heights[i] * heights[i]);

            String status = getBmiStatus(bmi);

            System.out.printf(
                "%d | %.2f | %.2f | %.2f | %s%n",
                i + 1,
                heights[i],
                weights[i],
                bmi,
                status
            );
        }
    }

    public static void main(String[] args) {

        Random random = new Random();

        int n = 10;

        double[] heights = new double[n];
        double[] weights = new double[n];

        for (int i = 0; i < n; i++) {

            heights[i] = 1.50 + random.nextDouble();
            weights[i] = 45 + (55 * random.nextDouble());
        }

        printWellnessReport(heights, weights);
    }
}
