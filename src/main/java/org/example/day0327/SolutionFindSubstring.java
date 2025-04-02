package org.example.day0327;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouchengliang
 * <p>
 * leetcode 30题
 * 串联所有单词的子串
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 * s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 *
 * 最终方法有3个用例过不了
 * 滑动窗口的没搞懂
 */
public class SolutionFindSubstring {

    Map<String, Integer> wordsMap = new HashMap<>();

    public List<Integer> findSubstring(String s, String[] words) {
        int tot = 0;
        for (String word : words) {
            tot += word.length();
            Integer cnt = wordsMap.getOrDefault(word, 0) + 1;
            wordsMap.put(word, cnt);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i + tot <= s.length(); i++) {
            if (valid(s.substring(i, i + tot), words)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean valid(String s, String[] words) {
        int k = words[0].length();
        Map<String, Integer> splitWordsMap = new HashMap<>();
        for (int i = 0; i < s.length(); i += k) {
            String word = s.substring(i, i + k);
            Integer cnt = splitWordsMap.getOrDefault(word, 0) + 1;
            splitWordsMap.put(word, cnt);
        }
        return equalsMap(wordsMap, splitWordsMap);
    }

    public boolean equalsMap(Map<String, Integer> wordsMap, Map<String, Integer> splitWordsMap) {
        for (Map.Entry<String, Integer> entry : splitWordsMap.entrySet()) {
            if (!wordsMap.containsKey(entry.getKey())) {
                return false;
            }
            if (entry.getValue() != wordsMap.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

}
