package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.PriorityQueue;

public class Q1642 {
    class Solution {
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 사다리로 처리할 후보 점프들
            for (int i = 0; i < heights.length - 1; i++) {
                int diff = heights[i + 1] - heights[i];
                if (diff <= 0) continue;          // 내려가면 비용 0

                minHeap.offer(diff);              // 일단 사다리 후보에 넣고
                if (minHeap.size() > ladders) {   // 사다리 수를 초과하면,
                    bricks -= minHeap.poll();     // 가장 작은 점프 하나를 벽돌로 지불
                    if (bricks < 0) return i;     // 벽돌도 모자라면 여기서 멈춤
                }
            }
            return heights.length - 1;            // 끝까지 도달
        }
    }

}
