package Leetcode;

/*
1. 아이디어 :
해시맵을 사용하여 각 숫자에 대해 이전 숫자와의 차이가 difference인 경우의 길이를 저장

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
해시맵 / dp
 */

import java.util.HashMap;
import java.util.Map;

public class Q1218 {
    class Solution {
        public int longestSubsequence(int[] arr, int difference) {
            int n = arr.length;
            int ans = 1;
            int prev = arr[0];
            Map<Integer, Integer> lengths = new HashMap<>();

            for (int num : arr) {
                if (lengths.containsKey(num - difference)) {
                    int length = lengths.get(num - difference);
                    lengths.remove(num-difference);
                    if (lengths.containsKey(num)) {
                        lengths.put(num, Math.max(lengths.get(num), length+1));
                    } else {
                        lengths.put(num, length+1);
                    }
                } else {
                    lengths.putIfAbsent(num, 1);
                }
            }
            System.out.println(lengths);
            for (int length : lengths.values()) {
                ans = Math.max(ans, length);
            }
            return ans;
        }
    }
}
