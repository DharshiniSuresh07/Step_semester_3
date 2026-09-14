package oop_fundamentals.class_problems.classes_and_objects.assignment_problems;

import java.util.Scanner;

class EmployeeData {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Permanent employee
    public EmployeeData(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Intern
    public EmployeeData(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs "
                + salary + " | Intern: " + isIntern);
    }
}

public class EmployeeProfile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter permanent employee details:");

        System.out.print("Employee ID: ");
        String id1 = sc.nextLine();

        System.out.print("Employee name: ");
        String name1 = sc.nextLine();

        System.out.print("Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        EmployeeData permanent = new EmployeeData(id1, name1, salary);

        System.out.println("\nEnter intern details:");

        System.out.print("Employee ID: ");
        String id2 = sc.nextLine();

        System.out.print("Employee name: ");
        String name2 = sc.nextLine();

        EmployeeData intern = new EmployeeData(id2, name2);

        System.out.println("\nEmployee Profiles:");

        permanent.printProfile();
        intern.printProfile();

        sc.close();
    }
}