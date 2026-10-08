package Abstraction_and_Interface.assignmentproblems;
import java.util.*;
abstract class Ticket{
    static final double FEE=20;
    int count;
    Ticket(int count){
        this.count=count;
    }
    abstract double price();
    double total(){
        return count*(price()+FEE);
    }
    abstract String seat();
}
class Regular extends Ticket{
    Regular(int count){
        super(count);
    }
    double price(){
        return 150;
    }
    String seat(){
        return "REGULAR";
    }
}
class Premium extends Ticket{
    Premium(int count){
        super(count);
    }
    double price(){
        return 250;
    }
    String seat(){
        return "PREMIUM";
    }
}
class Recliner extends Ticket{
    Recliner(int count){
        super(count);
    }
    double price(){
        return 400;
    }
    String seat(){
        return "RECLINER";
    }
}
public class MovieTicketCounter{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Ticket[] tickets=new Ticket[n];
        double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next();
            int count=sc.nextInt();
            if(type.equals("REGULAR"))
                tickets[i]=new Regular(count);
            else if(type.equals("PREMIUM"))
                tickets[i]=new Premium(count);
            else
                tickets[i]=new Recliner(count);
        }
        for(Ticket t:tickets){
            System.out.printf("%s: %.2f%n",t.seat(),t.total());
            total+=t.total();
        }
        System.out.printf("Total: %.2f%n",total);
    }
}
