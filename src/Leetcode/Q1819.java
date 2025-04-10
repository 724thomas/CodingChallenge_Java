package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.Set;

public class Q1819 {
    class Solution {
        public int gcd(int a, int b) {
            return (b==0)? a:gcd(b, a%b);
        }

        public int countDifferentSubsequenceGCDs(int[] nums) {
            Set<Integer> visited = new HashSet<>();
            for (int num : nums) visited.add(num);
            int ans = 0;

            for (int target = 1; target <= 200001; target ++) {
                int currGCD = 0;
                for (int multiple = target; multiple <= 200001; multiple += target) {
                    if (visited.contains(multiple)) {
                        currGCD = gcd(currGCD, multiple);
                    }
                    // System.out.println(target + " " + multiple + " " + currGCD);
                    if (currGCD == target) {
                        ans++;
                        // System.out.println(currGCD);
                        break;
                    }
                }
            }




            return ans;
        }
    }
}
