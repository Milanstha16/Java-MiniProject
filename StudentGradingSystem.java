import java.util.Scanner;

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

public class StudentGradingSystem {

    public static String calculateGrade(int marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B+";
        else if (marks >= 60) return "B";
        else if (marks >= 50) return "C";
        else return "F";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println();
            System.out.print("Enter student name: ");
            String name = sc.nextLine().trim();

            String formattedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

            System.out.print("Enter student marks: ");
            String marksInput = sc.nextLine().trim();

            int marks;
            try {
                marks = Integer.parseInt(marksInput);
            } catch (NumberFormatException e) {
                throw new InvalidMarksException("Marks must be a number!");
            }

            if (marks < 0 || marks > 100) {
                throw new InvalidMarksException("Marks must be between 0 and 100.");
            }

            String grade = calculateGrade(marks);
            System.out.println("\n--- Student Report ---");
            System.out.println("Name  : " + formattedName);
            System.out.println("Marks : " + marks);
            System.out.println("Grade : " + grade);

        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("\nThank you for using the Student Grading System.");
            sc.close();
        }
    }
}
