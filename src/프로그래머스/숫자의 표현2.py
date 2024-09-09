# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''

'''
import java.util.*;
class Solution {
    public int solution(int n) {
        int left = 1, right=1, total=1, ans=1;
        while (right < n){
            if (total == n) {
                ans++;
                total -= left;
                left++;
            } else if (total < n) {
                right++;
                total += right;
            } else if (total > n) {
                total -= left;
                left++;
            }
        }
        return ans;
    }
}'''