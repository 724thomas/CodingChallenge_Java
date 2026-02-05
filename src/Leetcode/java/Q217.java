package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.Set;

public class Q217 {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> dup = new HashSet<>();
            for (int num : nums) {
                if (dup.contains(num)) return true;
                dup.add(num);
            }
            return false;
        }
    }
}
