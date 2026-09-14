package oop_fundamentals.class_problems.classes_and_objects.class_problems;

import java.util.Scanner;

class IdCard {
    String name;
    int booksIssued;

    IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class M4_IdCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial books issued: ");
        int books = sc.nextInt();

        IdCard ravi = new IdCard(name, books);

        // Second variable points to the same object
        IdCard duplicate = ravi;

        System.out.print("Enter new books issued: ");
        duplicate.booksIssued = sc.nextInt();

        // Third object is separate
        IdCard separate = new IdCard(name, duplicate.booksIssued);

        System.out.println("\n" + name + "'s booksIssued (via first variable): "
                + ravi.booksIssued);

        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        System.out.println("separate == ravi: " + (separate == ravi));

        sc.close();
    }
}