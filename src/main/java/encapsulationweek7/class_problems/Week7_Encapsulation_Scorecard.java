package encapsulationweek7.class_problems;

class Scorecard {
    private final boolean[] results;
    private int recorded;

    Scorecard(int capacity) {
        results = new boolean[Math.max(0, capacity)];
    }

    public void recordAnswer(boolean correct) {
        if (recorded < results.length) results[recorded++] = correct;
    }

    public int getScore() {
        int score = 0;
        for (int index = 0; index < recorded; index++) if (results[index]) score++;
        return score;
    }
}

public class Week7_Encapsulation_Scorecard {
    public static void main(String[] args) {
        Scorecard scorecard = new Scorecard(3);
        scorecard.recordAnswer(true);
        scorecard.recordAnswer(false);
        scorecard.recordAnswer(true);
        System.out.println("Score: " + scorecard.getScore());
    }
}
