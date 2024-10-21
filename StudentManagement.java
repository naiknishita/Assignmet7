package bank;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Student<N, R, M> {
    N name;
    R rollNo;
    M marks;

    Student(N name, R rollNo, M marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks: " + marks);
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        ArrayList<Student<String, Integer, Integer>> studentList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        int i;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter Student Name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter Roll No: ");
                            int rollNo = sc.nextInt();
                            System.out.print("Enter Marks: ");
                            int marks = sc.nextInt();

                            
                            Student<String, Integer, Integer> student = new Student<>(name, rollNo, marks);
                            studentList.add(student);
                            System.out.println("Student added successfully!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter numeric values for Roll No and Marks.");
                            sc.nextLine(); 
                        }
                        break;

                    case 2:
                        
                        if (studentList.isEmpty()) {
                            System.out.println("No students to display.");
                        } else {
                            System.out.println("\nList of Students:");
                            
                            for(i=0;i<studentList.size();i++){
                                System.out.println("Student " + (i + 1) + ":");
                                studentList.get(i).printDetails();
                                System.out.println();
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice! Please select a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.nextLine(); 
            }
        } while (choice != 3);

        sc.close();
    }
}

