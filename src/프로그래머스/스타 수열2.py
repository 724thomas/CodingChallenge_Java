# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    숫자 종류와 등장횟수를 구한다.
    부분 집합을 만들지 않고, 각 숫자에 대해 i와 i+1을 비교하면서 짝을 구한다.
    숫자의 등장횟수가 지금까지의 최대값보다 작으면 계산하지 않는다. (정렬을 하면 더 빠를수도..)
2. 시간복잡도 :
    O( n*n )
3. 자료구조 :
    해시맵

import java.util.*;
class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int ans = 0;
        if (n < 2) return ans;

        HashMap<Integer, Integer> counter = new HashMap<>();
        for (var num : a) counter.put(num, counter.getOrDefault(num, 0)+1);

        for (var num : counter.keySet()){
            if (counter.get(num) < ans) continue;
            int count = 0;
            int i = 0;
            while (i < n-1) {
                if ((a[i] == num || a[i+1] == num) && a[i] != a[i+1]){
                    count++;
                    i += 2;
                } else {
                    i++;
                }
            }
            ans = Math.max(ans, count);
        }
        return ans*2;

    }
}
'''


from collections import Counter
def solution(a):
    n, ans = len(a), 0
    if n<2: return 0

    for k, v in Counter(a).items():
        if (v < ans): continue
        count, i = 0, 0
        while (i < n-1):
            if (a[i] == k or a[i+1] == k) and a[i] != a[i+1]:
                count+=1
                i+=2
            else:
                i+=1
        ans = max(ans, count)
    return ans*2
