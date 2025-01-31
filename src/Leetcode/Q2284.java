package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q2284 {
    class Solution {
        public String largestWordCount(String[] messages, String[] senders) {
            int n = messages.length;
            Map<String, Integer> counter = new HashMap<>();

            int maxCount = 0;
            String ans = "";
            for (int i=0; i<n; i++) {
                int count = messages[i].split(" ").length;
                counter.put(senders[i], counter.getOrDefault(senders[i], 0)+count);

                int currCount = counter.get(senders[i]);
                if (currCount > maxCount) {
                    maxCount = counter.get(senders[i]);
                    ans = senders[i];
                } else if (currCount == maxCount && ans.compareTo(senders[i]) < 0) {
                    ans = senders[i];
                }
            }

            return ans;
        }
    }
}
