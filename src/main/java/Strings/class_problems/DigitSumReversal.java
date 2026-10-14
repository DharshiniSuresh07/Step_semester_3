package Strings.class_problems;

import java.util.*;

public class DigitSumReversal{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),sum=0,rev=0;
        while(n>0){
            int digit=n%10;
            sum+=digit;
            rev=rev*10+digit;
            n/=10;
        }
        System.out.println("Sum of digits: "+sum);
        System.out.println("Reverse: "+rev);
        sc.close();
    }
}
