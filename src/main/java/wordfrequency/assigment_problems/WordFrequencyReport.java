package wordfrequency.assigment_problems;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class WordFrequencyReport {

    static final Set<String> STOP_WORDS = Set.of("the", "was", "and", "a", "is", "of", "in");

    static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase()
                                  .replace(".", "")
                                  .replace(",", "");

        String[] words = cleaned.split("\\s+");

        Map<String, Integer> frequency = new LinkedHashMap<>();

        for (String word : words) {
            if (word.isEmpty() || STOP_WORDS.contains(word)) {
                continue;
            }
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
