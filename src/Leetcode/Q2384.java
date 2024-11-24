package Leetcode;

import java.util.*;

public class Q2384 {
    class Solution {

        public String largestPalindromic(String num) {
            Map<Character, Integer> counter = new HashMap<>();
            Set<Character> visited = new HashSet<>();
            PriorityQueue<Character> candid = new PriorityQueue<>((a, b) -> {
                return b-a;
            });

            for (char c : num.toCharArray()) {
                counter.put(c, counter.getOrDefault(c, 0)+1);
                if (counter.get(c) < 2 || visited.contains(c)) continue;
                visited.add(c);
                candid.offer(c);
            }

            StringBuilder leftHalf = new StringBuilder();
            while (!candid.isEmpty()) {
                Character curr = candid.poll();
                int counts = counter.get(curr);
                for (int i=0; i<counts/2; i++) {
                    leftHalf.append(curr);
                }
            }

            char mid = '!';
            for (var entry:counter.entrySet()){
                if (entry.getValue()%2==1 && entry.getKey()>mid) mid = entry.getKey();
            }

            if (!leftHalf.toString().equals("") && leftHalf.charAt(0) == '0') leftHalf = new StringBuilder();

            StringBuilder rightHalf = new StringBuilder();
            for (Character c : leftHalf.toString().toCharArray()) rightHalf.append(c);

            if (mid != '!') leftHalf.append(mid);
            leftHalf.append(rightHalf.reverse());
            return leftHalf.toString().equals("") ? "0" : leftHalf.toString();
        }
    }
}
