import java.util.*;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int sum = 0;

        for (int mark : marks) {
            sum = sum + mark;
        }

        return (double) sum / marks.length;
    }

    char calculateGrade() {
        double average = calculateAverage();

        if (average >= 90) {
            return 'A';
        } else if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    void display() {
        System.out.printf("%s: Average %.1f, Grade %c%n",
                name.toUpperCase(),
                calculateAverage(),
                calculateGrade());
    }
}

public class week10_cq10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name1 = sc.next();
        int[] marks1 = new int[3];

        for (int i = 0; i < 3; i++) {
            marks1[i] = sc.nextInt();
        }

        String name2 = sc.next();
        int[] marks2 = new int[3];

        for (int i = 0; i < 3; i++) {
            marks2[i] = sc.nextInt();
        }

        Student s1 = new Student(name1, marks1);
        Student s2 = new Student(name2, marks2);

        s1.display();
        s2.display();
    }
}

