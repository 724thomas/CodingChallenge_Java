package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.Set;

public class Q873 {
    class Solution {
        public int lenLongestFibSubseq(int[] arr) {
            int ans = 2;
            int n = arr.length;
            Set<Integer> nums = new HashSet<>();
            for (int num:arr) nums.add(num);

            for (int i=0; i<n; i++) for (int j=i+1; j<n; j++) {
                int val1 = arr[i], val2 = arr[j], length = 2;

                while (nums.contains(val1 + val2)) {
                    length++;
                    int temp = val1;
                    val1 = val2;
                    val2 = temp+val2;
                }
                ans = Math.max(ans, length);
            }

            return (ans==2) ? 0 : ans;
        }
    }
}
