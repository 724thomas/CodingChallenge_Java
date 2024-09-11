# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


'''
class Solution {
    public int solution(int n, int m, int[] section) {
        int ans = 0;
        int idx = 1;
        int[] wall = new int[n+1];
        for (int num: section){
            wall[num] = 1;
        }
        
        while (idx<=n){
            if (wall[idx] == 1){
                ans++;
                idx += m;
            } else {
                idx++;
            }
        }
        return ans;
    }
}'''