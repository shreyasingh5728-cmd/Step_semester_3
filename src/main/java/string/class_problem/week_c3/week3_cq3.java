import java.util.Scanner;

public class week3_cq3 {

    public static void guessTheNumber(int secretNumber, int maxTries, int[] guesses) {

        int tries = 0;
        int i = 0;
        boolean guessed = false;

        while (tries < maxTries && i < guesses.length && !guessed) {

            int guess = guesses[i];

            if (guess > secretNumber) {
                System.out.println("Too high");
            } 
            else if (guess < secretNumber) {
                System.out.println("Too low");
            } 
            else {
                System.out.println("Correct! You guessed it");
                guessed = true;
                break;
            }

            tries++;
            i++;
        }

        if (!guessed && tries >= maxTries) {
            System.out.println("Out of tries — the number was " + secretNumber);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter secret number: ");
        int secretNumber = sc.nextInt();

        System.out.print("Enter maximum number of tries: ");
        int maxTries = sc.nextInt();

        System.out.print("Enter number of guesses: ");
        int n = sc.nextInt();

        int[] guesses = new int[n];

        System.out.println("Enter guesses:");
        for (int i = 0; i < n; i++) {
            guesses[i] = sc.nextInt();
        }

        guessTheNumber(secretNumber, maxTries, guesses);

        sc.close();
    }
}


