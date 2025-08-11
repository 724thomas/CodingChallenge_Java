package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3633 {
    class Solution {
        public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
            int ans = Integer.MAX_VALUE;
            int n = landStartTime.length, m = waterStartTime.length;

            for (int i=0; i<n; i++) {
                int landStart = landStartTime[i], landDur = landDuration[i];
                for (int j=0; j<m; j++) {
                    int waterStart = waterStartTime[j], waterDur = waterDuration[j];
                    ans = Math.min(ans, Math.max(waterStart, landStart + landDur) + waterDur);
                    ans = Math.min(ans, Math.max(landStart, waterStart + waterDur) + landDur);
                }
            }
            return ans;
        }
    }
}
