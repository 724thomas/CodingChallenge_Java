package Leetcode.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q916 {

    class Solution {
        public Map<Character, Integer> stringToMap(String word) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : word.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            return map;
        }

        public boolean isSuperset(Map<Character, Integer> map1, Map<Character, Integer> map2) {
            for (var entry : map2.entrySet()) {
                if (map1.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    return false;
                }
            }
            return true;
        }

        public List<String> wordSubsets(String[] words1, String[] words2) {
            List<String> ans = new ArrayList<>();

            // Combine all frequency maps of words2 into one maximum frequency map
            Map<Character, Integer> combinedMap = new HashMap<>();
            for (String word : words2) {
                Map<Character, Integer> tempMap = stringToMap(word);
                for (var entry : tempMap.entrySet()) {
                    combinedMap.put(entry.getKey(),
                            Math.max(combinedMap.getOrDefault(entry.getKey(), 0), entry.getValue()));
                }
            }

            for (String word : words1) {
                Map<Character, Integer> map1 = stringToMap(word);
                if (isSuperset(map1, combinedMap)) {
                    ans.add(word);
                }
            }

            return ans;
        }
    }

}
