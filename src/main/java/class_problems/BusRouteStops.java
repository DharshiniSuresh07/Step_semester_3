package class_problems;

import java.util.*;

class Node{
    String data;
    Node next;

    Node(String data){
        this.data=data;
        this.next=null;
    }
}

public class BusRouteStops{
    static Node build(String[] stops){
        Node head=null,tail=null;

        for(String stop:stops){
            Node newNode=new Node(stop);

            if(head==null){
                head=newNode;
                tail=newNode;
            }else{
                tail.next=newNode;
                tail=newNode;
            }
        }
        return head;
    }

    static void printRoute(Node head){
        Node current=head;
        int count=0;
        String first=head.data,last="";

        while(current!=null){
            System.out.print(current.data+" -> ");
            last=current.data;
            count++;
            current=current.next;
        }

        System.out.println("null");
        System.out.println("Stops: "+count+", First: "+first+", Last: "+last);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();

        String[] stops=new String[n];

        for(int i=0;i<n;i++){
            stops[i]=sc.nextLine().trim();
        }

        Node head=build(stops);
        printRoute(head);
    }
}