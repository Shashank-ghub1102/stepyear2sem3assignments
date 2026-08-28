package control_flow.assigment_problems;

public class MultiplicationTableGenerator {

    static void generateFirstValidTable(int[] candidates) {
        for (int candidate : candidates) {
            if (candidate < 1) {
                System.out.println("Skipping invalid number: " + candidate);
                continue;
            }

            for (int multiplier = 1; multiplier <= 10; multiplier++) {
                System.out.println(candidate + " x " + multiplier + " = " + candidate * multiplier);
            }
            break;
        }
    }

    public static void main(String[] args) {
        generateFirstValidTable(new int[]{-3, 0, 7, 9});
    }
}