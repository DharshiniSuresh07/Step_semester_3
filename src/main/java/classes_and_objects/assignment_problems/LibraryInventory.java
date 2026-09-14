package oop_fundamentals.class_problems.classes_and_objects.assignment_problems;

import java.util.Scanner;

class Book {
    String title;
    String author;
    int copiesAvailable;

    Book(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry() {
        System.out.println(title + " by " + author + " - "
                + copiesAvailable + " copies available");
    }
}

public class LibraryInventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book[] books = new Book[4];

        for (int i = 0; i < 4; i++) {
            System.out.print("Enter book title: ");
            String title = sc.nextLine();

            System.out.print("Enter author: ");
            String author = sc.nextLine();

            System.out.print("Enter copies available: ");
            int copies = sc.nextInt();
            sc.nextLine();

            books[i] = new Book(title, author, copies);
        }

        System.out.println("\nLibrary Inventory:");

        for (Book book : books) {
            book.printEntry();
        }

        sc.close();
    }
}
