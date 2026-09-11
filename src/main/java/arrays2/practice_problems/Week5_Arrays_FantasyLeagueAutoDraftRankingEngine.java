package arrays2.practice_problems;

import java.util.Arrays;

class Player implements Comparable<Player> {
    private final String name;
    private final int matchesPlayed;
    private final double battingAverage;
    private final boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, battingAverage);
    }

    static String draftAndRank(Player[] players) {
        int draftableCount = 0;
        for (Player player : players) {
            if (isDraftable(player.matchesPlayed)
                    || isDraftable(player.matchesPlayed, player.injured)) {
                draftableCount++;
            }
        }

        Player[] draftable = new Player[draftableCount];
        int next = 0;
        for (Player player : players) {
            if (isDraftable(player.matchesPlayed)
                    || isDraftable(player.matchesPlayed, player.injured)) {
                draftable[next++] = player;
            }
        }

        Arrays.sort(draftable);
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < draftable.length; index++) {
            if (index > 0) {
                result.append(" | ");
            }
            result.append(index + 1).append(". ").append(draftable[index].name);
        }
        return result.toString();
    }
}

public class Week5_Arrays_FantasyLeagueAutoDraftRankingEngine {
    public static void main(String[] args) {
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };
        System.out.println(Player.draftAndRank(players));
    }
}
