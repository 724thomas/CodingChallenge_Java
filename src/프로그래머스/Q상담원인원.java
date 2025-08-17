package 프로그래머스;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q상담원인원 {
    class Solution {
        int k, n;
        int[][] reqs;
        public int solution(int k, int n, int[][] reqs) {
            this.k = k;
            this.n = n;
            this.reqs = reqs;
        /*
        상담 유형의 수를 나타내는 정수 k
        멘토의 수를 나타내는 정수 n
        참가자의 상담 요청을 담은 2차원 정수 배열 reqs
        reqs의 원소는 [a, b, c]. c번 유형의 상담을 원하는 참가자가 a분에 b분 동안의 상담을 요청

        4^20
        [1,1,1,1,1]
        [1,1,1,1,1]

        */

            int[] mentor = new int[k];
            Arrays.fill(mentor, 1);
            int ans = getWaitingTime(mentor);
            for (int i=k+1; i<=n; i++) {
                int best = -1, currTime = ans;
                for (int j = 0; j<k; j++) {
                    mentor[j]++;
                    int time = getWaitingTime(mentor);
                    if (time < currTime) {
                        currTime = time;
                        best = j;
                    }
                    mentor[j]--;
                }
                mentor[best]++;
            }
            return getWaitingTime(mentor);
        }

        private int getWaitingTime(int[] mentor) {
            int delays = 0;
            Map<Integer, PriorityQueue<Integer>> pqMap = new HashMap<>();
            for (int i=0; i<k; i++) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();

                for (int j=0; j<mentor[i]; j++) {
                    pq.add(0);
                }
                pqMap.put(i, pq);
            }
            for (int[] req : reqs) {
                int start = req[0], end = req[1], num = req[2]-1;
                PriorityQueue<Integer> mentorPq = pqMap.get(num);
                int finishTime = mentorPq.poll();
                delays += Math.max(0, finishTime - start);
                mentorPq.add(Math.max(finishTime, start) + end);
            }
            return delays;
        }
    }
}
