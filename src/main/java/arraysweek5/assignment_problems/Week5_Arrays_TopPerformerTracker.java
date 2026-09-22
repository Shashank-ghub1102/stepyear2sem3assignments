package arraysweek5.assignment_problems;

public class Week5_Arrays_TopPerformerTracker {
    static String findMinMaxSpread(int[] scores) {
        int minimum = scores[0];
        int maximum = scores[0];

        for (int index = 1; index < scores.length; index++) {
            if (scores[index] < minimum) {
                minimum = scores[index];
            }
            if (scores[index] > maximum) {
                maximum = scores[index];
            }
        }

        return "Min: " + minimum + " | Max: " + maximum + " | Spread: " + (maximum - minimum);
    }

    public static void main(String[] args) {
        System.out.println(findMinMaxSpread(new int[]{45, 82, 79, 90, 33, 90, 61}));
    }
}
