package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q616 {
    class Solution {
        public String addBoldTag(String s, String[] words) {
            List<int[]> intervals = new ArrayList<>();

            for (String word : words) {
                int start = s.indexOf(word);
                while (start != -1) {
                    intervals.add(new int[]{start, start + word.length()});
                    start = s.indexOf(word, start + 1);
                }
            }

            if (intervals.size()==0) return s;
            Collections.sort(intervals, (a, b) -> a[0] - b[0]);

            List<int[]> mergedIntervals = new ArrayList<>();
            int[] curr = intervals.get(0);

            for (int i = 1; i < intervals.size(); i++) {
                int[] next = intervals.get(i);
                if (curr[1] >= next[0]) {
                    curr[1] = Math.max(curr[1], next[1]);
                } else {
                    mergedIntervals.add(curr);
                    curr = next;
                }
            }

            if (curr != null) mergedIntervals.add(curr);

            StringBuilder sb = new StringBuilder();
            int lastIdx = 0;

            for (int[] interval : mergedIntervals) {
                sb.append(s, lastIdx, interval[0]);
                sb.append("<b>").append(s, interval[0], interval[1]).append("</b>");
                lastIdx = interval[1];
            }

            sb.append(s.substring(lastIdx));

            return sb.toString();
        }
    }

}
