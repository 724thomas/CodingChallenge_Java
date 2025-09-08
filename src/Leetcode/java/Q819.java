package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q819 {
    class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            Set<String> bannedSet = new HashSet<>();
            for (String b : banned) bannedSet.add(b);

            Map<String, Integer> counter = new HashMap<>();
            StringBuilder sb = new StringBuilder();

            for (char c : paragraph.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    sb.append(Character.toLowerCase(c));
                } else {
                    if (sb.toString().length() != 0) {
                        String candid = sb.toString();
                        sb = new StringBuilder();
                        if (bannedSet.contains(candid)) continue;
                        counter.put(candid, counter.getOrDefault(candid, 0)+1);
                    }
                }
            }

            if (sb.toString().length() != 0) {
                String candid = sb.toString();
                if (!bannedSet.contains(candid)) {
                    counter.put(candid, counter.getOrDefault(candid, 0)+1);
                }
            }

            int maxCount = 0;
            String ans = "";
            for (var entry : counter.entrySet()) {
                String key = entry.getKey();
                int count = entry.getValue();
                if (count > maxCount) {
                    ans = key;
                    maxCount = count;
                }
            }

            return ans;

        }
    }
}
