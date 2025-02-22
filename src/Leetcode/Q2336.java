package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.TreeSet;

public class Q2336 {
    class SmallestInfiniteSet {
        TreeSet<Integer> treeSet;
        int next;

        public SmallestInfiniteSet() {
            treeSet = new TreeSet<>();
            next = 1;
        }

        public int popSmallest() {
            if (!treeSet.isEmpty() && treeSet.first() < next) {
                int val = treeSet.first();
                treeSet.remove(val);
                return val;
            } else {
                int val = next;
                next++;
                return val;
            }
        }

        public void addBack(int num) {
            if (num < next) treeSet.add(num);
        }
    }

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
}
