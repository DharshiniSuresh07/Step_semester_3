package test.encapsulation.class_problems;

import java.util.Scanner;

public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password=password;
    }

    public String getStrength() {
        if(password.length()<6) {
            return "Weak";
        } else if(password.length()<10) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter password: ");
        String password=sc.nextLine();

        PasswordChecker pc=new PasswordChecker(password);

        System.out.println("Password strength: "+pc.getStrength());

        sc.close();
    }
}
