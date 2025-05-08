package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Q1438 {
    class Pair {
        int num;
        int idx;
        public Pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            TreeSet<Pair> treeSet = new TreeSet<>((a, b)->{
                if (a.num != b.num) return Integer.compare(a.num, b.num);
                return Integer.compare(a.idx, b.idx);
            }); // num, idx
            Map<Integer, Pair> pairMap = new HashMap<>();

            int n = nums.length;
            int left = 0;
            int ans = 0;

            for (int right = 0; right<n; right++) {
                int rnum = nums[right];
                Pair rPair = new Pair(rnum, right);

                treeSet.add(rPair);
                pairMap.put(right, rPair);

                if (!treeSet.isEmpty() && (treeSet.last().num - treeSet.first().num > limit)) {
                    treeSet.remove(pairMap.get(left));
                    left++;
                }

                ans = Math.max(ans, treeSet.size());
            }
            return ans;
        }
    }
}
