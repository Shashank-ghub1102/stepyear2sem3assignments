package control_flow.class_problems;

import java.util.HashMap;
import java.util.Map;

public class Week1_ControlFlow_FirstNonRepeatingCharacter {
    static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char character : text.toCharArray()) counts.put(character, counts.getOrDefault(character, 0) + 1);
        for (char character : text.toCharArray()) if (counts.get(character) == 1) return character;
        return '\0';
    }

    public static void main(String[] args) {
        char result = findFirstNonRepeatingChar("swiss");
        System.out.println(result == '\0' ? "No Non-Repeating Character Found" : "First Non-Repeating Character: '" + result + "'");
    }
}