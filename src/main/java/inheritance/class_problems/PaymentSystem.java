package test.inheritance.class_problems;

import java.util.*;
abstract class Payment{
    String type;
    double amount;
    Payment(String type,double amount){
        this.type=type;
        this.amount=amount;
    }
    abstract double calculateAmount();
}
class Card extends Payment{
    Card(double amount){
        super("CARD",amount);
    }
    double calculateAmount(){
        return amount*1.02;
    }
}
class Wallet extends Payment{
    Wallet(double amount){
        super("WALLET",amount);
    }

    double calculateAmount(){
        return amount*1.01;
    }
}
class BankTransfer extends Payment {
    BankTransfer(double amount) {
        super("BANKTRANSFER", amount);
    }
    double calculateAmount() {
        return amount;
    }
}
public class PaymentSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next();
            double amount=sc.nextDouble();

            Payment payment;

            if(type.equals("CARD"))
                payment=new Card(amount);
            else if(type.equals("WALLET"))
                payment=new Wallet(amount);
            else
                payment=new BankTransfer(amount);
            double result=payment.calculateAmount();
            total+=result;
            System.out.printf("%s: %.2f%n",type,result);
        }
        System.out.printf("Total: %.2f%n",total);
    }
}
