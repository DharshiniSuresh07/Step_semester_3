package test.inheritance.assignment_problems;
import java.util.*;
abstract class Vehicle{
    int hours;
    Vehicle(int hours){
        this.hours=hours;
    }
    abstract double calculateCharge();
}
class Bike extends Vehicle{
    Bike(int hours){
        super(hours);
    }
    double calculateCharge(){
        return hours*10;
    }
}
class Car extends Vehicle{
    Car(int hours){
        super(hours);
    }
    double calculateCharge(){
        if(hours==1)
            return 30;
        return 30+(hours-1)*20;
    }
}
class Truck extends Vehicle{
    Truck(int hours){
        super(hours);
    }
    double calculateCharge(){
        return Math.max(hours*50,100);
    }
}
public class ParkingSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next();
            int hours=sc.nextInt();
            Vehicle v;
            if(type.equals("BIKE"))
                v=new Bike(hours);
            else if(type.equals("CAR"))
                v=new Car(hours);
            else
                v=new Truck(hours);
            double charge=v.calculateCharge();
            total+=charge;

            System.out.printf("%s: %.2f%n",type,charge);
        }
        System.out.printf("Total: %.2f%n",total);
    }
}
