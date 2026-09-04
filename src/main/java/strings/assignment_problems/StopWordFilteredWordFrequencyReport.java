package strings.assignment_problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StopWordFilteredWordFrequencyReport {
    static void printFilteredWordFrequency(String feedback) {
        Set<String> stopWords = Set.of("the", "was", "and", "a", "is", "of", "in");
        Map<String, Integer> frequencies = new HashMap<>();
        String cleaned = feedback.toLowerCase().replace(",", "").replace(".", "");
        for (String word : cleaned.split("\\s+")) if (!stopWords.contains(word)) frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequencies.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<String, Integer> entry : entries) System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}