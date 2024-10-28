# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    총 토핑의 갯수가 홀수면 둘로 나눌 수 없다.
    총 토핑의 종류 / 2를 목표로
    철수에게 하나씩 주면서 종류를 갱신, 동시에 총 종류의 갯수를 갱신
    목표와 같아지면 카운트
2. 시간복잡도 :
    O( n )
3. 자료구조 :
    해시맵, 해시셋

import java.util.*;
class Solution {
    public int solution(int[] toppings) {
        int[] counter = new int[10001];
        int counts = 0;
        int totalKinds = 0;
        for (int topping:toppings) {
            if (counter[topping] == 0) totalKinds ++;
            counter[topping]++;
        }
        if (counts % 2 == 1) return 0;
        int target = totalKinds / 2;

        int ans = 0;
        Set<Integer> chulsoo = new HashSet<>();
        int chulsooKinds = 0;
        for (int n: toppings){
            if (!chulsoo.contains(n)){
                chulsooKinds++;
                chulsoo.add(n);
            }

            counter[n]--;
            if (counter[n]==0) totalKinds --;
            if (totalKinds == chulsooKinds) ans++;
        }
        return ans;
    }
}

'''


from collections import defaultdict
def solution(toppings):
    total = defaultdict(int)
    total_kinds = 0
    for topping in toppings:
        if topping not in total: total_kinds +=1
        total[topping]+=1

    if sum(total.values()) % 2 == 1: return 0
    chulsoo = set()
    chulsoo_kind = 0
    ans = 0
    for topping in toppings:
        if topping not in chulsoo:
            chulsoo_kind +=1
            chulsoo.add(topping)

        total[topping] -=1
        if total[topping] == 0:
            total_kinds -=1

        if chulsoo_kind == total_kinds:
            ans+=1

    return ans