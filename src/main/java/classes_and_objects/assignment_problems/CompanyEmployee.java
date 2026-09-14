package oop_fundamentals.class_problems.classes_and_objects.assignment_problems;
import java.util.Scanner;

class CompanyWorker {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    CompanyWorker(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees created: " + employeeCount);
    }
}

public class CompanyEmployee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Enter employee " + i + " details:");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            new CompanyWorker(name, salary);
        }

        System.out.println("\nCompany Information:");

        // Calling static method using class name
        CompanyWorker.printCompanyInfo();

        sc.close();
    }
}
