package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q1018 {
    class Solution {
        public List<Boolean> prefixesDivBy5(int[] nums) {
            List<Boolean> ans = new ArrayList<>();
            int curr = 0;
            for (int num : nums) {
                curr = (curr*2 + num) % 5;
                ans.add(curr ==0);
            }
            return ans;
        }
    }
}
