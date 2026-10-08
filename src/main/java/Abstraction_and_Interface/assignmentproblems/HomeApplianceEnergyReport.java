package Abstraction_and_Interface.assignmentproblems;

import java.util.*;
abstract class Appliance{
    double hours;
    Appliance(double hours){
        this.hours=hours;
    }
    abstract double power();
    abstract String type();
    double units(){
        return power()*hours/1000;
    }
    double cost(){
        return units()*8;
    }
}
interface SaverMode{
    double saverUnits();
}
class Fridge extends Appliance{
    Fridge(double hours){
        super(hours);
    }
    double power(){
        return 150;
    }
    String type(){
        return "FRIDGE";
    }
}
class AC extends Appliance implements SaverMode{
    AC(double hours){
        super(hours);
    }
    double power(){
        return 1500;
    }
    public double saverUnits(){
        return units()*0.75;
    }
    String type(){
        return "AC";
    }
}
class TV extends Appliance{
    TV(double hours){
        super(hours);
    }
    double power(){
        return 100;
    }
    String type(){
        return "TV";
    }
}
class Washer extends Appliance implements SaverMode{
    Washer(double hours){
        super(hours);
    }
    double power(){
        return 500;
    }
    public double saverUnits(){
        return units()*0.75;
    }
    String type(){
        return "WASHER";
    }
}
public class HomeApplianceEnergyReport{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next();
            double hours=sc.nextDouble();
            boolean saver=false;
            if(sc.hasNext("SAVER")){
                sc.next();
                saver=true;
            }
            Appliance appliance;
            if(type.equals("FRIDGE"))
                appliance=new Fridge(hours);
            else if(type.equals("AC"))
                appliance=new AC(hours);
            else if(type.equals("TV"))
                appliance=new TV(hours);
            else
                appliance=new Washer(hours);
            if(saver&&!(appliance instanceof SaverMode)){
                System.out.println(type+": saver mode not supported");
            }else{
                double units=appliance.units();
                if(saver)
                    units=((SaverMode)appliance).saverUnits();
                double cost=units*8;
                System.out.printf("%s: Units=%.2f Cost=%.2f%n",type,units,cost);
                total+=cost;
            }
        }
        System.out.printf("Total Cost: %.2f%n",total);
    }
}
