import java.time.LocalDate;
import java.util.*;

interface LibraryItem {
    LocalDate getDueDate(LocalDate currentDate);
    String getTitle();
}

class Book implements LibraryItem {
    String title;

    Book(String title) {
        this.title = title;
    }

    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14);
    }

    public String getTitle() {
        return title;
    }
}

class DVD implements LibraryItem {
    String title;

    DVD(String title) {
        this.title = title;
    }

    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7);
    }

    public String getTitle() {
        return title;
    }
}

class Magazine implements LibraryItem {
    String title;

    Magazine(String title) {
        this.title = title;
    }

    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3);
    }

    public String getTitle() {
        return title;
    }
}

public class week_8q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine().trim();

            int space = line.indexOf(' ');

            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();

            // Remove quotes
            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title);
            } else if (type.equals("DVD")) {
                item = new DVD(title);
            } else {
                item = new Magazine(title);
            }

            LocalDate dueDate = item.getDueDate(currentDate);

            System.out.println(item.getTitle() + ": " + dueDate);
        }

        sc.close();
    }
}
