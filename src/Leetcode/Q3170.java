package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.PriorityQueue;

public class Q3170 {
    class Pair {
        char c;
        int idx;
        public Pair(char c, int idx) {
            this.c=c;
            this.idx=idx;
        }
    }
    class Solution {
        public String clearStars(String s) {
            int n = s.length();
            boolean[] survived = new boolean[n];

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
                if (a.c == b.c) return b.idx - a.idx;
                return a.c - b.c;
            }); // 인덱스 내림차순, 캐릭터 오름차순

            for (int i=0; i<n; i++) {
                char c = s.charAt(i);
                if (c!='*') {
                    survived[i] = true;
                    Pair pair = new Pair(c, i);
                    pq.add(pair);
                } else {
                    Pair pair = pq.poll();
                    survived[pair.idx] = false;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i=0; i<n; i++) {
                if (survived[i]) sb.append(s.charAt(i));
            }
            return sb.toString();
        }
    }
}
