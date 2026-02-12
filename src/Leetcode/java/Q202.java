package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.Set;

public class Q202 {
    class Solution {
        Set<Integer> visited = new HashSet<>();
        public boolean isHappy(int n) {
            String sn = String.valueOf(n);
            int sum = 0;
            for (char c : sn.toCharArray()) {
                sum += Math.pow(Integer.parseInt(c+""),2);
            }

            if (sum==1) return true;
            if (visited.contains(sum)) return false;
            visited.add(sum);
            return isHappy(sum);
        }
    }
}
