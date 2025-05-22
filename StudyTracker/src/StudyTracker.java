import java.util.*;

public class StudyTracker {
    static Map<String, List<Integer>> studyData = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Study Time Tracker ---");
            System.out.println("1. Add study session");
            System.out.println("2. View total time by subject");
            System.out.println("3. View average time by subject");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            //Selecting your option
            switch (choice) {
                case 1 -> addStudySession();
                case 2 -> viewTotalTime();
                case 3 -> viewAverageTime();
                case 4 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    //adding subject and the time you studied - number 1
    static void addStudySession() {
        System.out.print("Enter subject: ");
        String subject = scanner.nextLine();
        System.out.print("Enter minutes studied: ");
        int minutes = scanner.nextInt();
        scanner.nextLine(); // Clear newline

        studyData.putIfAbsent(subject, new ArrayList<>());
        studyData.get(subject).add(minutes);

        System.out.println("Session added.");
    }

    //shows the total time you studied - number 2
    static void viewTotalTime() {
        for (String subject : studyData.keySet()) {
            int total = studyData.get(subject).stream().mapToInt(Integer::intValue).sum();
            System.out.println(subject + ": " + total + " minutes");
        }
    }

    //shows the average time you studied for each subject - number 3
    static void viewAverageTime() {
        for (String subject : studyData.keySet()) {
            List<Integer> sessions = studyData.get(subject);
            double avg = sessions.stream().mapToInt(Integer::intValue).average().orElse(0);
            System.out.printf("%s: %.2f minutes/session\n", subject, avg);
        }
    }
}
