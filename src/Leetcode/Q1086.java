package Leetcode;

import java.util.*;
import static java.util.Collections.reverseOrder;
public class Q1086 {


    class Solution {
        public int[][] highFive(int[][] items) {
            Map<Integer, List<Integer>> itemsMap = new HashMap<>();
            for (int[] item : items) {
                int student = item[0], score = item[1];
                itemsMap.putIfAbsent(student, new ArrayList<>());
                itemsMap.get(student).add(score);
            }

            int[][] ans = new int[itemsMap.size()][2];
            int idx = 0;
            for (var entry : itemsMap.entrySet()) {
                int student = entry.getKey();
                List<Integer> scores = entry.getValue();
                Collections.sort(scores, reverseOrder());
                int total = 0;

                for (int i=0; i<Math.min(5, scores.size()); i++) total += scores.get(i);
                total /= 5;
                ans[idx++] = new int[]{student, total};
            }

            return ans;
        }
    }
}
