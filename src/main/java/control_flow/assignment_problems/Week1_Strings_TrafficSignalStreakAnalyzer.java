package control_flow.assignment_problems;

public class Week1_Strings_TrafficSignalStreakAnalyzer {

    static void findLongestStreak(String signalLog) {

        int current = 1;
        int longest = 1;
        char color = signalLog.charAt(0);

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                current++;
            }
            else {
                current = 1;
            }

            if (current > longest) {
                longest = current;
                color = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + color
                + "' repeated " + longest + " times");
    }

    public static void main(String[] args) {

        findLongestStreak("RRGGGYRR");
    }
}