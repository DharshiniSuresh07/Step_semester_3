package Abstraction_and_Interface.class_problems;
import java.util.*;
abstract class Booking{
    static final double FEE=50;
    double distance;
    Booking(double distance){
        this.distance=distance;
    }
    abstract double fare();
    double total(){
        return fare()+FEE;
    }
    abstract String mode();
}
class Bus extends Booking{
    Bus(double distance){
        super(distance);
    }
    double fare(){
        return 2*distance;
    }
    String mode(){
        return "BUS";
    }
}
class Train extends Booking{
    Train(double distance){
        super(distance);
    }
    double fare(){
        return 1.5*distance;
    }
    String mode(){
        return "TRAIN";
    }
}
class Flight extends Booking{
    Flight(double distance){
        super(distance);
    }
    double fare(){
        return 2500+4*distance;
    }
    String mode(){
        return "FLIGHT";
    }
}
public class TravelBooking{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Booking[] bookings=new Booking[n];
        for(int i=0;i<n;i++){
            String type=sc.next();
            double distance=sc.nextDouble();
            if(type.equals("BUS")){
                bookings[i]=new Bus(distance);
            }else if(type.equals("TRAIN")){
                bookings[i]=new Train(distance);
            }else{
                bookings[i]=new Flight(distance);
            }
        }
        for(Booking b:bookings){
            System.out.printf("%s: %.2f%n",b.mode(),b.total());
        }
    }
}