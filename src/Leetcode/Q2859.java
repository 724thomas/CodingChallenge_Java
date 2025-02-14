package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.List;

public class Q2859 {
    class Solution {
        public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
            int ans = 0;
            for (int i = 0; i < nums.size(); i++)
                if (Integer.bitCount(i) == k)
                    ans += nums.get(i);
            return ans;
        }
    }
}
