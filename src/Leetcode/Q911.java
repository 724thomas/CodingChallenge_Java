package Leetcode;

/*
1. 아이디어 :
time에 따른 최고 투표자를 미리 계산합니다.
q 메서드가 호출될떄마다 이분탐색으로 시간에 해당하는 인덱스를 찾고, 그 인덱스의 투표자를 리턴

2. 시간복잡도 :
O( n ) / O( log n ) * 호출횟수(m)

3. 자료구조/알고리즘 :
해시맵 / 이분탐색
 */

import java.util.HashMap;
import java.util.Map;

public class Q911 {
    class TopVotedCandidate {
        int n;
        int[] times;
        int[] rank;

        public TopVotedCandidate(int[] persons, int[] times) {
            this.n = persons.length;
            this.times = times;
            this.rank = new int[n];

            Map<Integer, Integer> counter = new HashMap<>();
            int cmax = 0;
            int candid = -1;

            for (int i=0; i<n; i++) {
                int person = persons[i], time = times[i];
                counter.put(person, counter.getOrDefault(person, 0)+1);

                if (counter.get(person) >= cmax) { // >= 최근 반영
                    cmax = counter.get(person);
                    candid = person;
                }
                rank[i] = candid;
            }
        }

        public int q(int t) {
            int left = 0, right = n-1;

            while (left <= right) {
                int mid = left + (right-left)/2;
                if (times[mid] <= t) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return rank[right];

        }
    }

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
}
