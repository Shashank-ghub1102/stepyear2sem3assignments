package arrays2.practice_problems;

public class Week5_Arrays_DuplicateTeamNameFinder {
    static String findDuplicateTeam(String[] teamNames) {
        for (int first = 0; first < teamNames.length; first++) {
            for (int second = first + 1; second < teamNames.length; second++) {
                if (teamNames[first].equals(teamNames[second])) {
                    return "Duplicate Found: " + teamNames[first];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println(findDuplicateTeam(new String[]{"ByteForce", "CodeCrafters", "ByteForce"}));
    }
}
