package class_problems;

import java.util.*;

class LateStudentNode{
    String data;
    LateStudentNode next;

    LateStudentNode(String data){
        this.data=data;
        this.next=null;
    }
}

public class LateComers{
    static LateStudentNode addFirst(LateStudentNode head,String name){
        LateStudentNode newNode=new LateStudentNode(name);
        newNode.next=head;
        return newNode;
    }

    static LateStudentNode addLast(LateStudentNode head,String name){
        LateStudentNode newNode=new LateStudentNode(name);

        if(head==null){
            return newNode;
        }

        LateStudentNode current=head;

        while(current.next!=null){
            current=current.next;
        }

        current.next=newNode;
        return head;
    }

    static void printLine(LateStudentNode head){
        LateStudentNode current=head;

        while(current!=null){
            System.out.print(current.data+" -> ");
            current=current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        LateStudentNode head=null;

        int n=sc.nextInt();

        for(int i=0;i<n;i++){
            head=addLast(head,sc.next());
        }

        int operations=sc.nextInt();

        for(int i=0;i<operations;i++){
            String operation=sc.next();
            String name=sc.next();

            if(operation.equals("addFirst")){
                head=addFirst(head,name);
            }else if(operation.equals("addLast")){
                head=addLast(head,name);
            }
        }

        printLine(head);
    }
}