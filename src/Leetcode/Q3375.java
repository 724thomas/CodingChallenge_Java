package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.Set;

public class Q3375 {
    class Solution {
        public int minOperations(int[] nums, int k) {
            Set<Integer> numSet = new HashSet<>();
            numSet.add(k);
            for (int num : nums) {
                if (num < k) return -1;
                numSet.add(num);
            }
            return numSet.size()-1;
        }
    }
}
