public class week3_cq4 {

    public static void generateFirstValidTable(int[] candidates) {

        for (int i = 0; i < candidates.length; i++) {

            int number = candidates[i];

            if (number < 1) {
                System.out.println("Skipping invalid number: " + number);
                continue;
            }

            for (int j = 1; j <= 10; j++) {
                System.out.println(number + " x " + j + " = " + (number * j));
            }

            break;
        }
    }

    public static void main(String[] args) {

        int[] candidates = {-3, 0, 7, 9};

        generateFirstValidTable(candidates);
    }
}


