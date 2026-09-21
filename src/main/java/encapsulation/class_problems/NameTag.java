package test.encapsulation.class_problems;

import java.util.Scanner;

class UserNameTag {
    private final String firstName;
    private final String lastName;

    public UserNameTag(String fullName) {
        String[] parts=fullName.split(" ");
        firstName=parts[0];
        lastName=parts[1];
    }

    public String getNickname() {
        return firstName+" "+lastName.charAt(0)+".";
    }
}

public class NameTag {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter full name: ");
        String name=sc.nextLine();

        UserNameTag tag=new UserNameTag(name);

        System.out.println("Nickname: "+tag.getNickname());

        sc.close();
    }
}