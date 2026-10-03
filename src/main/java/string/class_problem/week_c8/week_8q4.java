import java.util.*;

interface Question {
    double calculateScore();
    String getType();
}

class MCQ implements Question {

    String correctAnswer;
    String studentAnswer;
    double points;

    MCQ(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double calculateScore() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }

    public String getType() {
        return "MCQ";
    }
}

class TF implements Question {

    String correctAnswer;
    String studentAnswer;
    double points;

    TF(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double calculateScore() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }

    public String getType() {
        return "TF";
    }
}

class Essay implements Question {

    String correctAnswer;
    String studentAnswer;
    double points;

    Essay(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double calculateScore() {

        String[] keywords = correctAnswer.split(",");

        int count = 0;

        String answer = studentAnswer.toLowerCase();

        for (String keyword : keywords) {

            keyword = keyword.trim().toLowerCase();

            if (answer.contains(keyword)) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }

    public String getType() {
        return "ESSAY";
    }
}

public class week_8q4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            List<String> parts = new ArrayList<>();

            boolean insideQuotes = false;
            StringBuilder current = new StringBuilder();

            for (int j = 0; j < line.length(); j++) {

                char ch = line.charAt(j);

                if (ch == '"') {
                    insideQuotes = !insideQuotes;
                } 
                else if (ch == ' ' && !insideQuotes) {

                    if (current.length() > 0) {
                        parts.add(current.toString());
                        current.setLength(0);
                    }

                } 
                else {
                    current.append(ch);
                }
            }

            if (current.length() > 0) {
                parts.add(current.toString());
            }

            String type = parts.get(0);
            String correctAnswer = parts.get(2);
            String studentAnswer = parts.get(3);
            double points = Double.parseDouble(parts.get(4));

            Question question;

            if (type.equals("MCQ")) {

                question = new MCQ(
                        correctAnswer,
                        studentAnswer,
                        points
                );

            } else if (type.equals("TF")) {

                question = new TF(
                        correctAnswer,
                        studentAnswer,
                        points
                );

            } else {

                question = new Essay(
                        correctAnswer,
                        studentAnswer,
                        points
                );
            }

            double score = question.calculateScore();

            System.out.printf("%s: %.2f%n",
                    question.getType(), score);

            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);

        sc.close();
    }
}
