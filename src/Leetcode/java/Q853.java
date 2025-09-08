package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q853 {
    class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            int n = position.length;
            int[][] arr = new int[n][2];
            for (int i=0; i<n; i++) {
                arr[i][0] = position[i];
                arr[i][1] = speed[i];
            }
            Arrays.sort(arr, (a, b)->b[0]-a[0]);
            Deque<Double> deque = new ArrayDeque<>();

            for (int i=0; i<n; i++) {
                double time = ((double)target - arr[i][0]) / arr[i][1];
                if (!deque.isEmpty() && deque.peekLast() >= time) continue;
                deque.add(time);
            }

            return deque.size();
        }
    }
}
