package class_problem;

public class DiceThrowTally {
    public static int[] diceSort(int[] rolls) {
        int[] count=new int[7];

        for(int i=0;i<rolls.length;i++) {
            count[rolls[i]]++;
        }

        System.out.print("Counts: ");
        for(int i=1;i<=6;i++) {
            System.out.print(i+":"+count[i]+" ");
        }

        int[] result=new int[rolls.length];
        int index=0;

        for(int i=1;i<=6;i++) {
            for(int j=0;j<count[i];j++) {
                result[index]=i;
                index++;
            }
        }

        System.out.println();
        System.out.println("Sorted: "+java.util.Arrays.toString(result));

        return result;
    }

    public static void main(String[] args) {
        int[] rolls={4,1,6,4,2,1,4};
        diceSort(rolls);

        int[] rolls2={3,5,3,1,6,2};
        diceSort(rolls2);
    }
}
