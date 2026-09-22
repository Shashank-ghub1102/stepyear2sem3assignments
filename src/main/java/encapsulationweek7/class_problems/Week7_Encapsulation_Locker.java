package encapsulationweek7.class_problems;

class Locker {
    private String code;

    Locker(String code) {
        this.code = code;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (code.equals(currentCode) && newCode != null && !newCode.isEmpty()) {
            code = newCode;
            return true;
        }
        return false;
    }
}

public class Week7_Encapsulation_Locker {
    public static void main(String[] args) {
        Locker locker = new Locker("1234");
        System.out.println(locker.changeCode("1234", "5678"));
    }
}
