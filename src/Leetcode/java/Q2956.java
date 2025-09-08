package Leetcode.java;

/*
1. 아이디어 :
두개의 해시셋을 만듭니다.
nums1의 원소를 set1에 넣고, nums2의 원소를 set2에 넣습니다.
nums1/2의 원소를 순회하면서 set2/1에 있는지 확인하고, 있으면 ans[0/1]을 증가시킵니다.

2. 시간복잡도 :
O( n + m)

3. 자료구조/알고리즘 :
해시셋 / 부르트 포스
 */

import java.util.HashSet;
import java.util.Set;

public class Q2956 {
    class Solution {
        public int[] findIntersectionValues(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            for (int num : nums1) set1.add(num);
            Set<Integer> set2 = new HashSet<>();
            for (int num : nums2) set2.add(num);

            int[] ans = new int[2];
            for (int num : nums1) if (set2.contains(num)) ans[0]++;
            for (int num : nums2) if (set1.contains(num)) ans[1]++;
            return ans;
        }
    }
}
