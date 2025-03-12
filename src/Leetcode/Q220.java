package Leetcode;

/*
1. 아이디어 :
슬라이딩 윈도우 + 트리셋
슬라이딩 윈도우를 통해 indexDiff를 만족하는 후보들을 저장.
트리셋을 통해 값들을 정렬된 상태로 유지.
- ceiling(num - valueDiff)을 통해 x 이상의 값중 가장 작은 값을 찾음
- floor(num + valueDiff)을 통해 x 이하의 값중 가장 큰 값을 찾음
- 둘 값들 중 valueDiff보다 작은 차이값이 있으면 true
윈도우에서 벗어나는 값은 treeSet에서 O(logn)로 삭제.


2. 시간복잡도 :
O( n * 2logn )

3. 자료구조/알고리즘 :
deque, treeset / 슬라이딩 윈도우, 정렬
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeSet;

public class Q220 {
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            int n = nums.length;
            Deque<int[]> deque = new ArrayDeque<>();
            TreeSet<int[]> treeSet = new TreeSet<>((a, b) -> {
                if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[0], b[0]);
            });

            for (int i=0; i<n; i++) {
                int num = nums[i];
                if (!deque.isEmpty() && deque.peekFirst()[1] < i-indexDiff) {
                    int[] erase = deque.pollFirst();
                    treeSet.remove(erase);
                }

                // nums[i] + diff이하의 값중 큰 값
                int[] floor = treeSet.floor(new int[]{nums[i] + valueDiff, 0});
                // nums[i] - diff이상의 값중 작은 값
                int[] ceil = treeSet.ceiling(new int[]{nums[i] - valueDiff, 0});

                if ((floor != null && Math.abs(floor[0] - num) <= valueDiff)
                        || (ceil != null && Math.abs(ceil[0] - num) <= valueDiff)) return true;

                int[] pair = new int[]{num, i};
                deque.add(pair);
                treeSet.add(pair);
            }

            return false;
        }
    }
}
