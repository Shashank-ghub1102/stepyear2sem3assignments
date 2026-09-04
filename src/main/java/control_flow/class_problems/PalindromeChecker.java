package control_flow.class_problems;

public class PalindromeChecker {
    static boolean isPalindromeIterative(String text) {
        for (int left = 0, right = text.length() - 1; left < right; left++, right--)
            if (text.charAt(left) != text.charAt(right)) return false;
        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        if (text.length() < 2) return true;
        return text.charAt(0) == text.charAt(text.length() - 1)
                && isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] reversed = text.toCharArray();
        for (int left = 0, right = reversed.length - 1; left < right; left++, right--) {
            char temp = reversed[left];
            reversed[left] = reversed[right];
            reversed[right] = temp;
        }
        return text.equals(new String(reversed));
    }

    public static void main(String[] args) {
        String text = "madam";
        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                result(isPalindromeIterative(text)), result(isPalindromeRecursive(text)),
                result(isPalindromeArrayReversal(text)));
    }

    private static String result(boolean palindrome) {
        return palindrome ? "Palindrome" : "Not Palindrome";
    }
}