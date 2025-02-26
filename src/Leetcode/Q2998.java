package Leetcode;

/*
1. 아이디어 :
bfs 처럼 문제를 풀었습니다.
x부터 시작하여 4방향(값)에 대해 확인하고 y에 도착하는지 확인

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
해시셋, 배열 / bfs
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q2998 {
    class Solution {
        public List<Integer> getNextNums(int num) {
            List<Integer> candids = new ArrayList<>();
            if (num%11 == 0) candids.add(num/11);
            if (num%5 ==0) candids.add(num/5);
            candids.add(num-1);
            candids.add(num+1);
            return candids;
        }
        public int minimumOperationsToMakeEqual(int x, int y) {
            if (x==y) return 0;
            int count = 0;

            List<Integer> prev = new ArrayList<>();
            prev.add(x);
            Set<Integer> visited = new HashSet<>();
            visited.add(x);

            while (true) {
                List<Integer> curr = new ArrayList<>();
                for (int num : prev) {
                    if (num == y) return count;
                    for (int candid : getNextNums(num)) {
                        if (visited.contains(candid)) continue;
                        visited.add(candid);
                        curr.add(candid);
                    }
                }
                count++;
                prev = curr;
            }
        }
    }
}
