package test.encapsulation.class_problems;

import java.util.Scanner;

public class Locker {
    private String code;
    private final int lockerNumber;

    public Locker(int lockerNumber,String code) {
        this.lockerNumber=lockerNumber;
        this.code=code;
    }

    public void changeCode(String oldCode,String newCode) {
        if(code.equals(oldCode)) {
            code=newCode;
            System.out.println("Code changed successfully.");
        } else {
            System.out.println("Wrong current code. Change rejected.");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter locker number: ");
        int number=sc.nextInt();
        sc.nextLine();

        System.out.print("Enter current code: ");
        String code=sc.nextLine();

        Locker locker=new Locker(number,code);

        System.out.print("Enter old code: ");
        String oldCode=sc.nextLine();

        System.out.print("Enter new code: ");
        String newCode=sc.nextLine();

        locker.changeCode(oldCode,newCode);

        sc.close();
    }
}