# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public int deserialize(String time) {
        int[] hm = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        return hm[0] * 60 + hm[1];
    }
    public int solution(String[][] book_times) {
        int n = book_times.length;
        List<int[]> ibook_time = new ArrayList<>();
        for (String[] time : book_times) {
            ibook_time.add(new int[]{deserialize(time[0]), deserialize(time[1])});
        }
        Collections.sort(ibook_time, (a, b) -> a[0]-b[0]);

        int ans = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] time : ibook_time) {
            int start = time[0], end = time[1];
            while (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            pq.offer(end+10);
            ans = Math.max(ans, pq.size());
        }
        return ans;
    }
}
'''



