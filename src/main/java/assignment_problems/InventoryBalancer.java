package assignment_problems;
import java.util.Scanner;

public class InventoryBalancer{
    static void analyzeInventory(int[] sectionA,int[] sectionB){
        int totalA=0,totalB=0;
        int max=sectionA[0];
        String section="Section A";
        int index=0;

        for(int i=0;i<sectionA.length;i++){
            totalA=totalA+sectionA[i];

            if(sectionA[i]>max){
                max=sectionA[i];
                section="Section A";
                index=i;
            }
        }

        for(int i=0;i<sectionB.length;i++){
            totalB=totalB+sectionB[i];

            if(sectionB[i]>max){
                max=sectionB[i];
                section="Section B";
                index=i;
            }
        }

        String status;

        if(totalA==totalB)
            status="Balanced";
        else
            status="Not Balanced";

        System.out.println("Section A Total: "+totalA);
        System.out.println("Section B Total: "+totalB);
        System.out.println("Status: "+status);
        System.out.println("Highest Quantity: "+max+
                " ("+section+", Item "+(index+1)+")");
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n=sc.nextInt();

        int[] sectionA=new int[n];
        int[] sectionB=new int[n];

        System.out.println("Enter Section A quantities:");
        for(int i=0;i<n;i++)
            sectionA[i]=sc.nextInt();

        System.out.println("Enter Section B quantities:");
        for(int i=0;i<n;i++)
            sectionB[i]=sc.nextInt();

        analyzeInventory(sectionA,sectionB);
    }
}
