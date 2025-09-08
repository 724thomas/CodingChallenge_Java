package Leetcode.java;

/*
1. 아이디어 :
우선순위큐을 이용해서 가장 큰 값을 반으로 줄이는 작업을 반복

2. 시간복잡도 :
O( nlogn )

3. 자료구조/알고리즘 :
우선순위 큐 / -
 */

import java.util.PriorityQueue;

public class Q2208 {
    class Solution {
        public int halveArray(int[] nums) {
            int n = nums.length, ans = 0;
            double total = 0.0;
            PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b,a));
            for (int num : nums) {
                total += num;
                pq.add(num + 0.0);
            }

            double target = total / 2;
            while (total > target) {
                ans++;
                double halfed = pq.poll()/2;
                total -= halfed;
                pq.add(halfed);
            }
            return ans;
        }
    }
}
