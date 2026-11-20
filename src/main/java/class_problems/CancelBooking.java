package class_problems;

import java.util.*;
class BookingNode{
    String data;
    BookingNode next;
    BookingNode(String data){
        this.data=data;
        this.next=null;
    }
}
public class CancelBooking{
    static boolean found=false;

    static BookingNode removeFirst(BookingNode head,String booking){
        found=false;

        if(head==null){
            return null;
        }

        if(head.data.equals(booking)){
            found=true;
            return head.next;
        }

        BookingNode current=head;

        while(current.next!=null){
            if(current.next.data.equals(booking)){
                found=true;
                current.next=current.next.next;
                break;
            }
            current=current.next;
        }

        return head;
    }

    static void printBookings(BookingNode head){
        BookingNode current=head;

        while(current!=null){
            System.out.print(current.data+" -> ");
            current=current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        BookingNode head=null;
        BookingNode tail=null;

        for(int i=0;i<n;i++){
            BookingNode newNode=new BookingNode(sc.next());

            if(head==null){
                head=newNode;
                tail=newNode;
            }else{
                tail.next=newNode;
                tail=newNode;
            }
        }

        String booking=sc.next();
        head=removeFirst(head,booking);

        if(!found){
            System.out.println(booking+" not found");
        }

        printBookings(head);
    }
}
