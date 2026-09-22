package arraysweek5.assignment_problems;

public class Week5_Arrays_HackathonSeatingGridOptimizer {
    private static double rowAverage(int[] row) {
        int total = 0;
        for (int score : row) {
            total += score;
        }
        return (double) total / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int rowIndex = 0; rowIndex < seatingScores.length; rowIndex++) {
            if (rowIndex > 0) {
                result.append(" | ");
            }
            String zone = rowAverage(seatingScores[rowIndex]) < threshold
                    ? "Quiet Zone"
                    : "Buzzing Zone";
            result.append("Row ").append(rowIndex).append(": ").append(zone);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] scores = {{40, 50, 45}, {85, 90, 95}, {30, 20, 25}};
        System.out.println(classifyRows(scores, 60));
    }
}
