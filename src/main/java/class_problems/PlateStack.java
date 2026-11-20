package class_problems;

import java.util.*;

class StackPlateNode{
    String data;
    StackPlateNode next;

    StackPlateNode(String data){
        this.data=data;
        this.next=null;
    }
}

public class PlateStack{
    static StackPlateNode top=null;
    static int size=0;

    static void push(String plate){
        StackPlateNode newNode=new StackPlateNode(plate);
        newNode.next=top;
        top=newNode;
        size++;
        System.out.println("push "+plate+" -> top "+top.data+", size "+size);
    }

    static String pop(){
        if(isEmpty()){
            System.out.println("pop -> stack is empty");
            return null;
        }

        String plate=top.data;
        top=top.next;
        size--;
        System.out.println("pop -> "+plate+", size "+size);
        return plate;
    }

    static String peek(){
        if(isEmpty()){
            System.out.println("peek -> stack is empty");
            return null;
        }

        System.out.println("peek -> "+top.data);
        return top.data;
    }

    static boolean isEmpty(){
        return top==null;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        for(int i=0;i<n;i++){
            String operation=sc.next();

            if(operation.equals("push")){
                push(sc.next());
            }else if(operation.equals("pop")){
                pop();
            }else if(operation.equals("peek")){
                peek();
            }else if(operation.equals("isEmpty")){
                System.out.println("isEmpty -> "+isEmpty());
            }
        }
    }
}