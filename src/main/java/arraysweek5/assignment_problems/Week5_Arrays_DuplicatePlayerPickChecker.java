package arraysweek5.assignment_problems;

public class Week5_Arrays_DuplicatePlayerPickChecker {
    static String findDuplicatePick(String[] playerNames) {
        for (int first = 0; first < playerNames.length; first++) {
            for (int second = first + 1; second < playerNames.length; second++) {
                if (playerNames[first].equals(playerNames[second])) {
                    return "Duplicate Found: " + playerNames[first];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println(findDuplicatePick(new String[]{"Kohli", "Bumrah", "Kohli", "Rohit"}));
    }
}
