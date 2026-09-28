package test.inheritance.class_problems;

import java.util.*;
abstract class Question{
    String correctAnswer;
    String studentAnswer;
    double points;
    Question(String correctAnswer,String studentAnswer,double points){
        this.correctAnswer=correctAnswer;
        this.studentAnswer=studentAnswer;
        this.points=points;
    }
    abstract double grade();
}

class MCQ extends Question{
    MCQ(String correctAnswer,String studentAnswer,double points){
        super(correctAnswer,studentAnswer,points);
    }

    double grade(){
        return correctAnswer.equals(studentAnswer)?points:0;
    }
}

class TF extends Question {
    TF(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double grade() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
}
class Essay extends Question{
    Essay(String correctAnswer,String studentAnswer,double points){
        super(correctAnswer,studentAnswer,points);
    }
    double grade(){
        String answer=studentAnswer.toLowerCase();
        String[] keywords=correctAnswer.split(",");
        int count=0;
        for(String keyword:keywords){
            if(answer.contains(keyword.trim().toLowerCase()))
                count++;
        }
        if(count>=2)
            return points*0.75;
        if(count==1)
            return points*0.50;
        return 0;
    }
}
public class ExamGrader{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        double total=0;
        for(int i=0;i<n;i++){
            String line=sc.nextLine();
            String[] parts=line.split("\"");

            String type=parts[0].trim().split(" ")[0];
            String correctAnswer=parts[3];
            String studentAnswer=parts[5];
            double points=Double.parseDouble(parts[6].trim());

            Question question;

            if(type.equals("MCQ"))
                question=new MCQ(correctAnswer,studentAnswer,points);
            else if(type.equals("TF"))
                question=new TF(correctAnswer,studentAnswer,points);
            else
                question=new Essay(correctAnswer,studentAnswer,points);
            double score=question.grade();
            total+=score;
            System.out.printf("%s: %.2f%n",type,score);
        }
        System.out.printf("Total Score: %.2f%n",total);
    }
}