import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();

        int totalMarks = 0;

        // Loop to take marks of each subject
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks for subject " + i + " (out of 100): ");
            int marks = sc.nextInt();

            // Check for valid input
            while (marks < 0 || marks > 100) {
                System.out.print("Invalid marks! Enter again (0 to 100): ");
                marks = sc.nextInt();
            }

            totalMarks += marks;
        }

        // Calculate average percentage
        double average = (double) totalMarks / numSubjects;

        // Determine grade
        String grade;
        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F (Fail)";
        }

        // Display results
        System.out.println("\n📊 Result Summary:");
        System.out.println("Total Marks = " + totalMarks + " out of " + (numSubjects * 100));
        System.out.println("Average Percentage = " + average + "%");
        System.out.println("Grade = " + grade);

        sc.close();
    }
}
