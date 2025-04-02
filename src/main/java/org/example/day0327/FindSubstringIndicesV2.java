package org.example.day0327;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstringIndicesV2 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - totalLength; i++) {
            Map<String, Integer> currentCount = new HashMap<>();
            int j = 0;
            while (j < totalLength) {
                String word = s.substring(i + j, i + j + wordLength);
                if (!wordCount.containsKey(word)) {
                    break;
                }
                currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
                if (currentCount.get(word) > wordCount.get(word)) {
                    break;
                }
                j += wordLength;
            }
            if (j == totalLength) {
                result.add(i);
            }
        }
        return result;
    }
}
