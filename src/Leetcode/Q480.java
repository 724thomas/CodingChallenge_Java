package Leetcode;

/*
1. 아이디어 :
두개의 트리셋을 사용합니다.
left는 오름차순, right는 내림차순.
balance : 두 트리의 길이를 맞춰줍니다
add : 트리에 값을 더해줍니다
remove : 트리에 값을 제거합니다
getMedian : 중간값을 구합니다.

2. 시간복잡도 :
O( nlogn )

3. 자료구조/알고리즘 :
트리셋 / -
 */

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Q480 {
    class Pair {
        long val;
        int idx;

        public Pair(long val, int idx) {
            this.val=val;
            this.idx = idx;
        }
    }

    class Solution {
        int[] nums;
        int k;
        Map<Integer, Pair> map = new HashMap<>();

        TreeSet<Pair> left = new TreeSet<>((a, b) -> {
            if (a.val != b.val) return Long.compare(a.val, b.val);
            return Integer.compare(a.idx, b.idx);
        });
        TreeSet<Pair> right = new TreeSet<>((a,b) -> {
            if (a.val != b.val) return Long.compare(b.val, a.val);
            return Integer.compare(b.idx, a.idx);
        });

        public void balance() {
            if (left.size() > right.size() + 1) {
                right.add(left.pollLast());
            } else if (right.size() > left.size() +1) {
                left.add(right.pollFirst());
            }
        }

        private void add(int idx) {
            Pair pair = new Pair(nums[idx], idx);
            left.add(pair);
            map.put(idx, pair);
            right.add(left.pollFirst());
            if (left.size() < right.size()) {
                left.add(right.pollFirst());
            }
        }

        private void remove(int idx) {
            Pair target = map.get(idx);
            if (right.contains(target)) {
                right.remove(target);
                if (left.size() == right.size() +2) {
                    right.add(left.pollFirst());
                }
            } else {
                left.remove(target);
                if (left.size() < right.size()) {
                    left.add(right.pollFirst());
                }
            }
        }

        private double getMedian() {
            if (left.size() == right.size()) {
                return (double) (left.first().val + right.first().val)/2;
            }
            return left.first().val;
        }



        public double[] medianSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            this.nums = nums;
            this.k=k;
            double[] ans = new double[n - k + 1];

            for (int i=0; i<n; i++) {
                if (i>=k) {
                    remove(i-k);
                }
                add(i);
                if (i>=k-1) {
                    ans[i - k + 1] = getMedian();
                }
            }

            return ans;
        }
    }
}
