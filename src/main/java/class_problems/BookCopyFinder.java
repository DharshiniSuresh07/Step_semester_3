package class_problems;

import java.util.*;

class BookNode{
    String data;
    BookNode next;

    BookNode(String data){
        this.data=data;
        this.next=null;
    }
}

public class BookCopyFinder{
    static String find(BookNode head,String id){
        int position=1;
        int firstPosition=-1;
        int copies=0;

        BookNode current=head;

        while(current!=null){
            if(current.data.equals(id)){
                if(firstPosition==-1){
                    firstPosition=position;
                }
                copies++;
            }

            position++;
            current=current.next;
        }

        if(copies==0){
            return id+" not found";
        }

        return id+" first at position "+firstPosition+", copies: "+copies;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        BookNode head=null;
        BookNode tail=null;

        for(int i=0;i<n;i++){
            BookNode newNode=new BookNode(sc.next());

            if(head==null){
                head=newNode;
                tail=newNode;
            }else{
                tail.next=newNode;
                tail=newNode;
            }
        }

        String id=sc.next();
        System.out.println(find(head,id));
    }
}