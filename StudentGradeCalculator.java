import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("==========================================");
        System.out.println("     STUDENT GRADE CALCULATOR (CODSOFT)   ");
        System.out.println("==========================================");
        
        // Get number of subjects
        System.out.print("Enter the total number of subjects: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.next();
        }
        int numSubjects = scanner.nextInt();
        
        if (numSubjects <= 0) {
            System.out.println("Number of subjects must be greater than zero.");
            scanner.close();
            return;
        }
        
        double[] marks = new double[numSubjects];
        double totalMarks = 0;
        
        // Input marks for each subject (out of 100)
        for (int i = 0; i < numSubjects; i++) {
            while (true) {
                System.out.print("Enter marks obtained in Subject " + (i + 1) + " (out of 100): ");
                if (scanner.hasNextDouble()) {
                    double mark = scanner.nextDouble();
                    if (mark >= 0 && mark <= 100) {
                        marks[i] = mark;
                        totalMarks += mark;
                        break;
                    } else {
                        System.out.println("Marks should be between 0 and 100. Try again.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.next();
                }
            }
        }
        
        // Calculate average percentage
        double averagePercentage = totalMarks / numSubjects;
        
        // Grade Calculation logic
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }
        
        // Display Results
        System.out.println("\n==========================================");
        System.out.println("               RESULT SUMMARY             ");
        System.out.println("==========================================");
        System.out.println("Total Marks Obtained : " + totalMarks + " / " + (numSubjects * 100));
        System.out.printf("Average Percentage   : %.2f%%\n", averagePercentage);
        System.out.println("Corresponding Grade  : " + grade);
        System.out.println("==========================================");
        
        scanner.close();
    }
}