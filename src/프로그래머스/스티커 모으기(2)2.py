'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :


import java.util.*;
/*
class Solution {
    private int[] dp1, dp2;

    public int calc(int[] sticker, int idx, boolean first){
        int n = sticker.length;
        if (idx>= n) return 0;

        if (first) {
            if (idx == n-1) return 0;
            if (dp1[idx] != -1) return dp1[idx]; // visited
            dp1[idx] = Math.max(calc(sticker, idx+1, true), sticker[idx] + calc(sticker, idx+2, true));
            return dp1[idx];
        } else {
            if (dp2[idx] != -1) return dp2[idx]; // visited
            dp2[idx] = Math.max(calc(sticker, idx+1, false), sticker[idx] + calc(sticker, idx+2, false));
            return dp2[idx];
        }
    }
    public int solution(int sticker[]) {
        int n = sticker.length;
        if (n==1) return sticker[0];

        dp1 = new int[n];
        dp2 = new int[n];
        Arrays.fill(dp1, -1); // not visited = -1;
        Arrays.fill(dp2, -1);

        return Math.max(calc(sticker, 0, true), calc(sticker,1, false));
    }
}
*/

class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        if (n==1) return sticker[0];

        int[] dp1 = new int[n];
        dp1[0] = sticker[0];
        dp1[1] = Math.max(sticker[0], sticker[1]);
        for (int i=2; i<n-1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
        }

        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i=2; i<n; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }
        return Math.max(dp1[n-2], dp2[n-1]);
    }
}


'''


