package string_operations_and_performance.assignment_problems;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyReport{
    static void printFilteredWordFrequency(String feedback){
        feedback=feedback.toLowerCase();
        feedback=feedback.replace(".","");
        feedback=feedback.replace(",","");

        String[] words=feedback.split("\\s+");

        String[] stopWords={"the","was","and","a","is","of","in"};

        HashMap<String,Integer> frequency=new HashMap<>();

        for(int i=0;i<words.length;i++){
            boolean stop=false;

            for(int j=0;j<stopWords.length;j++){
                if(words[i].equals(stopWords[j])){
                    stop=true;
                    break;
                }
            }

            if(!stop){
                if(frequency.containsKey(words[i]))
                    frequency.put(words[i],frequency.get(words[i])+1);
                else
                    frequency.put(words[i],1);
            }
        }

        for(int count=words.length;count>=1;count--){
            for(Map.Entry<String,Integer> entry:frequency.entrySet()){
                if(entry.getValue()==count)
                    System.out.println(entry.getKey()+": "+entry.getValue());
            }
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback=sc.nextLine();

        printFilteredWordFrequency(feedback);
    }
}