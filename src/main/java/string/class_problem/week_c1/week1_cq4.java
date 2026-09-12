import java.util.*;

public class week1_cq4 {

    static char findFirstNonRepeatingChar(String text) {

        HashMap<Character, Integer> frequency = new HashMap<>();

        // Count frequency of every character
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (ch != ' ') {
                frequency.put(
                    ch,
                    frequency.getOrDefault(ch, 0) + 1
                );
            }
        }

        // Find first character with frequency 1
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (ch != ' ' && frequency.get(ch) == 1) {
                return ch;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word or short sentence: ");
        String text = sc.nextLine();

        char result = findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } 
        else {
            System.out.println(
                "First Non-Repeating Character: '" + result + "'"
            );
        }

        sc.close();
    }
}
