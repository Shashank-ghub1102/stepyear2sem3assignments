package strings.assignment_problems;

public class Week2_Strings_ATMPinLengthValidator {
    static void checkPinLength(String pin) {
        boolean valid = pin.length() == 4;
        for (int i = 0; valid && i < pin.length(); i++) valid = Character.isDigit(pin.charAt(i));
        System.out.println(valid ? "Valid PIN" : "Invalid PIN");
    }

    public static void main(String[] args) {
        checkPinLength("4821");
    }
}