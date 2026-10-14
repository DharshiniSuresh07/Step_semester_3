package Strings.assignment_problems;
import java.util.*;
public class ExamScoreBandCounter{
    static int countInBand(int[] scores,int low,int high){
        int left=lowerBound(scores,low);
        int right=upperBound(scores,high);
        return right-left;
    }
    static int lowerBound(int[] scores,int target){
        int l=0,r=scores.length;
        while(l<r){
            int mid=l+(r-l)/2;
            if(scores[mid]>=target){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }

    static int upperBound(int[] scores,int target){
        int l=0,r=scores.length;
        while(l<r){
            int mid=l+(r-l)/2;
            if(scores[mid]>target){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] scores=new int[n];
        for(int i=0;i<n;i++){
            scores[i]=sc.nextInt();
        }
        int low=sc.nextInt();
        int high=sc.nextInt();
        System.out.println(countInBand(scores,low,high));
        sc.close();
    }
}

