package Leetcode;

/*
1. 아이디어 :
n이 10^5까지 가능하므로, 플로이드 워셜, 다익스트라는 사용 불가. 각각 O(n^3), O(n * m).
n^2를 넘지 않는 범위에서 문제를 풀어야합니다.

edgeList와 query를 distance 기준으로 오름차순합니다. (query는 인덱스를 포함하여 재구성)
쿼리를 작은것부터 순회를 하면서 그룹을 형성합니다.
쿼리[i]의 MaxDistance보다 작은 edgeLsit들을 대상으로 union합니다.
MaxDistance보다 작은 edgeList를 union했을때, 쿼리의 start와 end가 같은 루트를 공유하는지 확인(find)


2. 시간복잡도 :
O( n(union-find에 필요한 par, size) + m(query 재구성) + logk(edgeList 정렬) + logm(query 정렬) + m(쿼리 순회) + n(edgeList 순회) + n(find) )
-> ( O(n) + O(m) + O(logk) + O(logm) + O(m) + O(n) + O(n) ) -> ( O(n + m + logk) )
k = edgeList의 길이

3. 자료구조/알고리즘 :
- / union-find

 */

import java.util.Arrays;

public class Q1697 {
    class Solution {
        int[] par;
        int[] size;

        public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
            int m = queries.length, k = edgeList.length;
            boolean[] ans = new boolean[m];
            par = new int[n];
            size = new int[n];
            for (int i=0; i<n; i++) { // O(n)
                par[i] = i;
                size[i] = 1;
            }

            for (int i=0; i<m; i++) { // O(m)
                queries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i}; // start, end, distance, index
            }
            Arrays.sort(queries, (a,b) -> a[2] - b[2]); // distance asc O(logn)
            Arrays.sort(edgeList, (a,b) -> a[2] - b[2]); // maxDistance asc O(logn)

            int last = 0;
            for (int[] query : queries) { // O(m)
                int start = query[0], end = query[1], maxDistance = query[2], index = query[3];

                for (int i=last; i<k && edgeList[i][2] < maxDistance; i++) { // O(n)
                    int u = edgeList[i][0], v = edgeList[i][1];
                    union(u, v); // O(n) -> O(1)
                    last = i;
                }
                ans[index] = find(start) == find(end);
            }
            return ans;
        }

        public int find(int a) { // O(n) -> O(1)
            if (par[a] != a) par[a] = find(par[a]);
            return par[a];
        }

        public void union(int a, int b) { // O(1)
            int ra = find(a), rb = find(b);
            if (ra == rb) return;

            if (size[ra] >= size[rb]) {
                par[rb] = ra;
                size[ra] += size[rb];
            } else {
                par[ra] = rb;
                size[rb] += size[ra];
            }
        }
    }
}
