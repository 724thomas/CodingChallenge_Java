package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Collections;
import java.util.List;

public class Q2895 {
    class Solution {
        public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
            Collections.sort(processorTime);
            Collections.reverse(processorTime);
            Collections.sort(tasks);
            int ans = 0;
            for (int i=0; i<processorTime.size(); i++) {
                int processor = processorTime.get(i);
                for (int j=i*4; j<i*4 + 4; j++) {
                    ans = Math.max(ans, processor + tasks.get(j));
                }
            }

            return ans;
        }
    }
}
