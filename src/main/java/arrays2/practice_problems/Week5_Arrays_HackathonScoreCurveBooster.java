package arrays2.practice_problems;

import java.util.Arrays;

public class Week5_Arrays_HackathonScoreCurveBooster {
    static void curveScores(int[] scores, int bonus) {
        for (int index = 0; index < scores.length; index++) {
            scores[index] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        curveScores(scores, 10);
        System.out.println(Arrays.toString(scores));
    }
}
