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
            StringBuilder sb = new StringBuilder();
            List<Boolean> ans = new ArrayList<>();
            for (int n : nums) {
                sb.append(n);
                ans.add( Integer.parseInt(sb.toString(), 2) % 5 ==0 );
            }
            return ans;
        }
    }
}
