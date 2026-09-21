 package test.encapsulation.class_problems;

import java.util.Scanner;
class QuizScore {
    private boolean[] answers;
    private final int totalQuestions;
    private int count;
    public QuizScore(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        answers = new boolean[totalQuestions];
        count = 0;
    }

    public void recordAnswer(boolean answer) {
        if (count < totalQuestions) {
            answers[count] = answer;
            count++;
        } else {
            System.out.println("No more answers can be recorded.");
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < count; i++) {
            if (answers[i]) {
                score++;
            }
        }

        return score;
    }
}

public class Scorecard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of questions: ");
        int n = sc.nextInt();

        QuizScore scorecard = new QuizScore(n);

        for (int i = 0; i < n; i++) {

            System.out.print("Was question " + (i + 1) + " correct? (true/false): ");
            boolean answer = sc.nextBoolean();

            scorecard.recordAnswer(answer);
        }

        System.out.println("Final Score: " + scorecard.getScore());

        sc.close();
    }
}

