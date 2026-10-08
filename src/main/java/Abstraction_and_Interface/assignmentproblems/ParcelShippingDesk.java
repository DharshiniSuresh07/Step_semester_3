package Abstraction_and_Interface.assignmentproblems;

import java.util.*;
abstract class Parcel{
    double weight,declaredValue;
    Parcel(double weight,double declaredValue){
        this.weight=weight;
        this.declaredValue=declaredValue;
    }
    abstract double charge();
    abstract String type();
    double insurance(){
        return 0;
    }
    double total(){
        return charge()+insurance();
    }
}
interface Insurable{
    double insurance();
}
class Standard extends Parcel{
    Standard(double weight,double declaredValue){
        super(weight,declaredValue);
    }
    double charge(){
        return 40+10*weight;
    }
    String type(){
        return "STANDARD";
    }
}
class Express extends Parcel implements Insurable{
    Express(double weight,double declaredValue){
        super(weight,declaredValue);
    }
    double charge(){
        return 80+15*weight;
    }
    public double insurance(){
        return declaredValue*0.02;
    }
    String type(){
        return "EXPRESS";
    }
}
class Fragile extends Parcel implements Insurable{
    Fragile(double weight,double declaredValue){
        super(weight,declaredValue);
    }
    double charge(){
        return 40+10*weight+50;
    }
    public double insurance(){
        return declaredValue*0.02;
    }
    String type(){
        return "FRAGILE";
    }
}
public class ParcelShippingDesk{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Parcel[] parcels=new Parcel[n];
        double grandTotal=0;
        for(int i=0;i<n;i++){
            String type=sc.next();
            double weight=sc.nextDouble();
            double value=sc.nextDouble();
            if(type.equals("STANDARD"))
                parcels[i]=new Standard(weight,value);
            else if(type.equals("EXPRESS"))
                parcels[i]=new Express(weight,value);
            else
                parcels[i]=new Fragile(weight,value);
        }
        for(Parcel p:parcels){
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    p.type(),p.charge(),p.insurance(),p.total());
            grandTotal+=p.total();
        }
        System.out.printf("Grand Total: %.2f%n",grandTotal);
    }
}