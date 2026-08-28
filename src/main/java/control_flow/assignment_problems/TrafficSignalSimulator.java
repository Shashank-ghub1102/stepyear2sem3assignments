package control_flow.assignment_problems;

public class TrafficSignalSimulator {

    static void simulateTrafficSignal(int cycles) {
        int state = 0;

        for (int cycle = 0; cycle < cycles; cycle++) {
            switch (state) {
                case 0:
                    System.out.println("Red - Stop");
                    break;
                case 1:
                    System.out.println("Green - Go");
                    break;
                case 2:
                    System.out.println("Yellow - Prepare to stop");
                    break;
                default:
                    break;
            }
            state = (state + 1) % 3;
        }
    }

    public static void main(String[] args) {
        simulateTrafficSignal(3);
    }
}