package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.Set;

public class Q128 {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            int longest = 0;

            for (int num : set) {
                // num - 1이 없다면, 이 숫자가 sequence의 시작
                if (!set.contains(num - 1)) {
                    int current = num;
                    int streak = 1;

                    while (set.contains(current + 1)) {
                        current++;
                        streak++;
                    }

                    longest = Math.max(longest, streak);
                }
            }

            return longest;
        }
    }

}
