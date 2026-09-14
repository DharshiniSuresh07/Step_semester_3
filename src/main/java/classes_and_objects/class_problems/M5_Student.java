package oop_fundamentals.class_problems.classes_and_objects.class_problems;

import java.util.Scanner;

class Student {
    String name;
    double attendance;

    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class M5_Student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first student name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter first student attendance: ");
        double attendance1 = sc.nextDouble();
        sc.nextLine();

        Student student1 = new Student(name1, attendance1);

        System.out.print("Enter second student name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter second student attendance: ");
        double attendance2 = sc.nextDouble();

        Student student2 = new Student(name2, attendance2);

        System.out.println("\nCollege Information:");
        Student.printCollegeInfo();

        sc.close();
    }
}