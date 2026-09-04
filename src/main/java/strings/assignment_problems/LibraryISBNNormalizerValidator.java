package strings.assignment_problems;

public class LibraryISBNNormalizerValidator {
    static String normalizeCode(String raw) {
        String code = raw.trim();
        if (code.length() < 3) return code.toUpperCase();
        return code.substring(0, 3).toUpperCase() + code.substring(3);
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) return "Invalid: wrong length";
        for (int i = 0; i < 3; i++) if (!Character.isLetter(code.charAt(i))) return "Invalid: publisher code must be 3 letters";
        for (int i = 3; i < code.length(); i++) if (!Character.isDigit(code.charAt(i))) return "Invalid: body must contain digits";
        return "[" + code.substring(0, 3) + "] YEAR: " + code.substring(3, 7) + " | CATALOG: " + code.substring(7);
    }

    public static void main(String[] args) {
        String normalized = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(normalized));
    }
}