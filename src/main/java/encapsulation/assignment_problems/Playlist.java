package test.encapsulation.class_problems;

import java.util.Scanner;

public class Playlist {
    private String[] songs;
    private int count;

    public Playlist(int size) {
        songs=new String[size];
        count=0;
    }

    public void addSong(String song) {
        if(count<songs.length) {
            songs[count]=song;
            count++;
        } else {
            System.out.println("Playlist is full.");
        }
    }

    public String[] getSongs() {
        String[] copy=new String[count];

        for(int i=0;i<count;i++) {
            copy[i]=songs[i];
        }

        return copy;
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter maximum number of songs: ");
        int size=sc.nextInt();
        sc.nextLine();

        Playlist playlist=new Playlist(size);

        System.out.print("Enter number of songs to add: ");
        int n=sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++) {
            System.out.print("Enter song "+(i+1)+": ");
            String song=sc.nextLine();
            playlist.addSong(song);
        }

        System.out.println("Song count: "+playlist.getSongCount());

        String[] copy=playlist.getSongs();

        System.out.println("Songs in playlist:");

        for(int i=0;i<copy.length;i++) {
            System.out.println(copy[i]);
        }

        sc.close();
    }
}