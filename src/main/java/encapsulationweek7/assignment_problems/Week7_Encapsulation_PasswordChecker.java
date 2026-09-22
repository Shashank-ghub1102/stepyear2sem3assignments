package encapsulationweek7.assignment_problems;

class PasswordChecker {
    private final String password;

    PasswordChecker(String password) {
        this.password = password == null ? "" : password;
    }

    public String getStrength() {
        if (password.length() < 6) return "Weak";
        if (password.length() >= 10 && password.matches(".*\\d.*")) return "Strong";
        return "Medium";
    }
}

public class Week7_Encapsulation_PasswordChecker {
    public static void main(String[] args) {
        System.out.println(new PasswordChecker("secret123").getStrength());
    }
}
