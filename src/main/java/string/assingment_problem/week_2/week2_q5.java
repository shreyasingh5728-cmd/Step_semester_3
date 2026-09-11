import java.util.*;

public class  week2_q5 {

    static void printFilteredWordFrequency(String feedback) {

        // Stop words
        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        // Convert to lowercase
        feedback = feedback.toLowerCase();

        // Remove punctuation
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        // Split into words
        String[] words = feedback.split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {

            // Check whether word is a stop word
            boolean isStopWord = false;

            for (String stop : stopWords) {
                if (word.equals(stop)) {
                    isStopWord = true;
                    break;
                }
            }

            if (isStopWord) {
                continue;
            }

            // Count frequency
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        // Sort by frequency
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(map.entrySet());

        list.sort((a, b) ->
                b.getValue() - a.getValue()
        );

        // Print result
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        String feedback =
            "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}
    

