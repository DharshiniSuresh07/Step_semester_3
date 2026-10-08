package Abstraction_and_Interface.assignmentproblems;

import java.util.*;
abstract class Cab{
    double km;
    Cab(double km){
        this.km=km;
    }
    abstract double rate();
    abstract String type();

    double fare(){
        return Math.max(km*rate(),100);
    }
}
interface NightService{
    double nightFare();
}
class Mini extends Cab{
    Mini(double km){
        super(km);
    }
    double rate(){
        return 10;
    }

    String type(){
        return "MINI";
    }
}
class Sedan extends Cab implements NightService{
    Sedan(double km){
        super(km);
    }
    double rate(){
        return 14;
    }
    public double nightFare(){
        return fare()*1.20;
    }
    String type(){
        return "SEDAN";
    }
}
class SUV extends Cab implements NightService{
    SUV(double km){
        super(km);
    }
    double rate(){
        return 18;
    }
    public double nightFare(){
        return fare()*1.20;
    }
    String type(){
        return "SUV";
    }
}
public class CityCabFareMeter{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next();
            double km=sc.nextDouble();
            String time=sc.next();
            Cab cab;
            if(type.equals("MINI"))
                cab=new Mini(km);
            else if(type.equals("SEDAN"))
                cab=new Sedan(km);
            else
                cab=new SUV(km);
            if(time.equals("NIGHT")&&!(cab instanceof NightService)){
                System.out.println(type+": night service not available");
            }else{
                double fare=cab.fare();
                if(time.equals("NIGHT"))
                    fare=((NightService)cab).nightFare();
                System.out.printf("%s: %.2f%n",type,fare);
                total+=fare;
            }
        }
        System.out.printf("Total: %.2f%n",total);
    }
}
