package oop_fundamentals.class_problems;
import java.util.Arrays;
import java.util.Scanner;
public class Problem5 {
    static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;
        public Candidate(String name,double cgpa,int codingScore) {
            this.name=name;
            this.cgpa=cgpa;
            this.codingScore=codingScore;
        }
        static boolean isEligible(double cgpa) {
            return cgpa>=7.5;
        }
        static boolean isEligible(double cgpa,int codingScore) {
            return cgpa>=6.5&&codingScore>=60;
        }
        double compositeScore() {
            return cgpa*10+codingScore*0.5;
        }
        public int compareTo(Candidate other) {
            return Double.compare(other.compositeScore(),compositeScore());
        }
    }
    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] temp=new Candidate[candidates.length];
        int count=0;
        for(Candidate candidate:candidates) {
            if(Candidate.isEligible(candidate.cgpa)||Candidate.isEligible(candidate.cgpa,candidate.codingScore)) {
                temp[count++]=candidate;
            }
        }
        Candidate[] shortlisted=Arrays.copyOf(temp,count);
        Arrays.sort(shortlisted);

        String result="";

        for(int i=0;i<shortlisted.length;i++) {
            result+=(i+1)+". "+shortlisted[i].name+" ("+shortlisted[i].compositeScore()+")";

            if(i<shortlisted.length-1) {
                result+=" | ";
            }
        }
        if(shortlisted.length==0) {
            return "No Candidates Shortlisted";
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n=sc.nextInt();
        sc.nextLine();

        Candidate[] candidates=new Candidate[n];

        for(int i=0;i<n;i++) {
            System.out.println("Enter candidate "+(i+1)+" details:");

            System.out.print("Enter name: ");
            String name=sc.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa=sc.nextDouble();
            System.out.print("Enter coding score: ");
            int codingScore=sc.nextInt();
            sc.nextLine();
            candidates[i]=new Candidate(name,cgpa,codingScore);
        }
        System.out.println(shortlistAndRank(candidates));
        sc.close();
    }
}
