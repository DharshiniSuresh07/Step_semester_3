package oop_fundamentals.class_problems;

import java.util.Arrays;
import java.util.Scanner;
public class Problem1 {
    static void curveScores(int[] scores,int bonus) {
        for(int i=0;i<scores.length;i++) {
            scores[i]+=bonus;
        }
        System.out.println(Arrays.toString(scores));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of scores: ");
        int n=sc.nextInt();
        int[] scores=new int[n];
        System.out.println("Enter scores:");
        for(int i=0;i<n;i++) {
            scores[i]=sc.nextInt();
        }
        System.out.print("Enter bonus: ");
        int bonus=sc.nextInt();
        curveScores(scores,bonus);
        sc.close();
    }
}
