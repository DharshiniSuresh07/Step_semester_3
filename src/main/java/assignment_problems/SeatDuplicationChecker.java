package assignment_problems;
import java.util.Scanner;

public class SeatDuplicationChecker{
    static void checkDuplicateSeats(int[] seats){
        boolean found=false;

        for(int i=0;i<seats.length;i++){
            for(int j=i+1;j<seats.length;j++){
                if(seats[i]==seats[j]){
                    System.out.println("Duplicate Seat Number Found: "+seats[i]);
                    found=true;
                    break;
                }
            }
        }

        if(!found)
            System.out.println("No Duplicate Seats Found");
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n=sc.nextInt();

        int[] seats=new int[n];

        for(int i=0;i<n;i++){
            System.out.print("Enter seat number: ");
            seats[i]=sc.nextInt();
        }

        checkDuplicateSeats(seats);
    }
}