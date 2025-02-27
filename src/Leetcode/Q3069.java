package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q3069 {
    class Solution {
        public int[] resultArray(int[] nums) {
            int n = nums.length;
            List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
            l1.add(nums[0]);
            l2.add(nums[1]);

            for (int i=2; i<n; i++) {
                int val = nums[i];
                if (l1.get(l1.size()-1) > l2.get(l2.size()-1)) {
                    l1.add(val);
                } else {
                    l2.add(val);
                }
            }

            int[] ans = new int[n];
            for (int i=0; i<l1.size(); i++) ans[i] = l1.get(i);
            for (int i=0; i<l2.size(); i++) ans[i+l1.size()] = l2.get(i);

            return ans;
        }
    }
}
