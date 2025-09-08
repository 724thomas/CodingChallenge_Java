package Leetcode.java;

import java.util.TreeSet;

public class Q264 {
    class Solution {
        public int nthUglyNumber(int n) {
            TreeSet<Long> treeSet = new TreeSet<>();
            treeSet.add(1L);
            for (int i=0; i<n-1; i++) {
                long c = treeSet.pollFirst();
                treeSet.add(c*2);
                treeSet.add(c*3);
                treeSet.add(c*5);
            }

            long ans = treeSet.pollFirst();
            return (int)ans;
        }
    }
}
