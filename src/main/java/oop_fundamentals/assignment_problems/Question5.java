package oop_fundamentals.assignment_problems;

import java.util.Arrays;
import java.util.Scanner;

public class Question5 {
    static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name,int matchesPlayed,double battingAverage,boolean injured) {
            this.name=name;
            this.matchesPlayed=matchesPlayed;
            this.battingAverage=battingAverage;
            this.injured=injured;
        }

        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed>=10;
        }

        static boolean isDraftable(int matchesPlayed,boolean injured) {
            return matchesPlayed>=5&&!injured;
        }

        public int compareTo(Player other) {
            return Double.compare(other.battingAverage,this.battingAverage);
        }
    }

    static String draftAndRank(Player[] players) {
        Player[] temp=new Player[players.length];
        int count=0;

        for(Player player:players) {
            if(Player.isDraftable(player.matchesPlayed)||Player.isDraftable(player.matchesPlayed,player.injured)) {
                temp[count]=player;
                count++;
            }
        }

        Player[] draftable=Arrays.copyOf(temp,count);

        Arrays.sort(draftable);

        if(draftable.length==0) {
            return "No Players Draftable";
        }

        String result="";

        for(int i=0;i<draftable.length;i++) {
            result+=(i+1)+". "+draftable[i].name;

            if(i<draftable.length-1) {
                result+=" | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n=sc.nextInt();
        sc.nextLine();

        Player[] players=new Player[n];

        for(int i=0;i<n;i++) {
            System.out.println("Enter Player "+(i+1)+" details:");

            System.out.print("Enter name: ");
            String name=sc.nextLine();

            System.out.print("Enter matches played: ");
            int matchesPlayed=sc.nextInt();

            System.out.print("Enter batting average: ");
            double battingAverage=sc.nextDouble();

            System.out.print("Is injured(true/false): ");
            boolean injured=sc.nextBoolean();
            sc.nextLine();

            players[i]=new Player(name,matchesPlayed,battingAverage,injured);
        }

        System.out.println(draftAndRank(players));

        sc.close();
    }
}