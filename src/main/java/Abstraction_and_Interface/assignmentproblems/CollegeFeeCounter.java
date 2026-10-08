package Abstraction_and_Interface.assignmentproblems;
import java.util.*;

abstract class Student{
    String name;
    static final double TRANSPORT_FEE=12000;
    Student(String name){
        this.name=name;
    }
    abstract double tuition();
    abstract boolean usesBus();
    double fee(){
        if(usesBus())
            return tuition()+TRANSPORT_FEE;
        return tuition();
    }
}
class DayScholar extends Student{
    DayScholar(String name){
        super(name);
    }
    double tuition(){
        return 40000;
    }
    boolean usesBus(){
        return true;
    }
}
class Hosteller extends Student{
    Hosteller(String name){
        super(name);
    }
    double tuition(){
        return 40000+60000;
    }
    boolean usesBus(){
        return false;
    }
}
class Scholar extends Student{
    Scholar(String name){
        super(name);
    }
    double tuition(){
        return 20000;
    }
    boolean usesBus(){
        return true;
    }
}
public class CollegeFeeCounter{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Student[] students=new Student[n];
        double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next();
            String name=sc.next();
            if(type.equals("DAY_SCHOLAR"))
                students[i]=new DayScholar(name);
            else if(type.equals("HOSTELLER"))
                students[i]=new Hosteller(name);
            else
                students[i]=new Scholar(name);
        }
        for(Student s:students){
            System.out.printf("%s: %.2f%n",s.name,s.fee());
            total+=s.fee();
        }
        System.out.printf("Total Collected: %.2f%n",total);
    }
}
