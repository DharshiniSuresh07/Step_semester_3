package assignment_problems;

import java.util.*;

class ReportStudent{
    private String name;
    private int a,b,c;

    ReportStudent(String name){
        this.name=name;
    }

    boolean setMarks(int a,int b,int c){
        if(a<0||a>100||b<0||b>100||c<0||c>100){
            return false;
        }

        this.a=a;
        this.b=b;
        this.c=c;
        return true;
    }

    int getTotal(){
        return a+b+c;
    }

    double getAverage(){
        return getTotal()/3.0;
    }

    String getGrade(){
        double avg=getAverage();

        if(avg>=80)return "A";
        if(avg>=70)return "B";
        if(avg>=60)return "C";
        if(avg>=40)return "D";
        return "F";
    }

    public String toString(){
        return name+" total="+getTotal()+" avg="+String.format("%.2f",getAverage())+" grade="+getGrade();
    }
}

public class ClassReportCard{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ReportStudent[] students=new ReportStudent[n];
        int count=0;

        for(int i=0;i<n;i++){
            String name=sc.next();
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();

            ReportStudent s=new ReportStudent(name);

            if(s.setMarks(a,b,c)){
                students[count++]=s;
            }else{
                System.out.println(name+" skipped: marks must be 0 to 100");
            }
        }

        int passes=0;

        for(int i=0;i<count-1;i++){
            boolean swapped=false;

            for(int j=0;j<count-1-i;j++){
                if(students[j].getTotal()<students[j+1].getTotal()){
                    ReportStudent temp=students[j];
                    students[j]=students[j+1];
                    students[j+1]=temp;
                    swapped=true;
                }
            }

            if(swapped){
                passes++;
            }else{
                break;
            }
        }

        for(int i=0;i<count;i++){
            System.out.println((i+1)+". "+students[i]);
        }

        System.out.println("Sorted in "+passes+" passes");
    }
}
