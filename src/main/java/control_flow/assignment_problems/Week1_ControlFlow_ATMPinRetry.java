package control_flow.assignment_problems;

public class Week1_ControlFlow_ATMPinRetry {

    static void atmPinRetry(String correctPin, String[] attempts) {
        int attemptIndex = 0;
        boolean pinAccepted = false;

        while (attemptIndex < attempts.length && attemptIndex < 3 && !pinAccepted) {
            if (correctPin.equals(attempts[attemptIndex])) {
                pinAccepted = true;
                System.out.println("PIN accepted");
                break;
            }
            attemptIndex++;
        }

        if (!pinAccepted) {
            System.out.println("Card blocked - too many incorrect attempts");
        }
    }

    public static void main(String[] args) {
        atmPinRetry("4821", new String[]{"1111", "4821"});
    }
}
