# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

class Solution {
    public int solution(int[] number) {
        int n = number.length;
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                for (int k=j+1; k<n; k++) {
                    if (number[i] + number[j] + number[k] == 0) ans++;
                }
            }
        }
        return ans;
    }
}

'''


