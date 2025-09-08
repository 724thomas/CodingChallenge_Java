package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q2848 {
    class Solution {
        public int numberOfPoints(List<List<Integer>> nums) {
            Set<Integer> ans = new HashSet<>();
            for (List<Integer> num: nums) {
                for (int i=num.get(0); i<=num.get(1); i++) {
                    ans.add(i);
                }
            }
            return ans.size();
        }
    }
}
