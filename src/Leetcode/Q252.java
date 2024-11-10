package Leetcode;

import java.util.Arrays;

public class Q252 {
    class Solution {
        public boolean canAttendMeetings(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
            int start = -1;
            for (int i=0; i<intervals.length; i++) {
                if (start > intervals[i][0]) return false;
                start = intervals[i][1];
            }
            return true;
        }
    }
}
