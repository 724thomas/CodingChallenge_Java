# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        ArrayList<Integer> jobs = new ArrayList<>();

        int base = -1;
        int count = 0;
        for (int i=0; i<n; i++) {
            int day = (int)Math.ceil((100.0-progresses[i]) / speeds[i]);
            if (base < day) {
                jobs.add(count);
                base = day;
                count = 1;
            } else {
                count ++;
            }
        }
        jobs.add(count);
        int[] ans = new int[jobs.size()-1];
        for (int i=1; i<jobs.size(); i++){
            ans[i-1] = jobs.get(i);
        }
        return ans;
    }
}

'''


