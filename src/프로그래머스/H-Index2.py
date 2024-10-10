# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.Arrays;

public class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int left = 0;
        int right = citations.length;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(citations, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    private boolean check(int[] citations, int n) {
        int len = citations.length;
        for (int i = 0; i < len; i++) {
            if (citations[i] >= n && (len - i) >= n) {
                return true;
            }
        }
        return false;
    }
}


'''

def solution(citations):
    citations.sort()
    c=citations
    def check(n):
        for i in range(len(c)):
            if c[i]>=n and len(c)-i>=n:
                return True
        return False

    left=0
    right=len(c)
    while left<=right:
        mid=(left+right)//2
        if check(mid):
            left=mid+1
        else:
            right=mid-1
    #print(left, right,mid)
    return right
