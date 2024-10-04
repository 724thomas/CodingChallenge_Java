# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    Map<String, Integer> counter;
    int kinds;
    String food;
    int ans;

    public int solution(String[] want, int[] number, String[] discount) {
        ans = 0;
        kinds = want.length;
        counter = new HashMap<>();
        for (int i=0; i<want.length; i++) counter.put(want[i], number[i]);

        for (int i=0; i<10; i++){
            food = discount[i];
            if (!counter.containsKey(food)) continue;
            counter.put(food, counter.get(food)-1);
            if (counter.get(food) == 0) kinds--;
        }
        if (kinds == 0) ans++;


        for (int i=0; i<discount.length-10; i++){
            food = discount[i];
            if (counter.containsKey(food)) {
                if (counter.get(food) == 0) kinds++;
                counter.put(food, counter.get(food)+1);
            }

            food = discount[i+10];
            if (counter.containsKey(food)) {
                counter.put(food, counter.get(food) - 1);
                if (counter.get(food) == 0) kinds--;
            }
            if (kinds == 0) ans++;
        }
        return ans;
    }
}

'''



def solution(want, number, discount):
    def inc_dec(is_increase, food):
        if food not in counter: return
        if is_increase:
            if counter[food] == 0: kind[0] +=1
            counter[food] +=1
        else:
            counter[food] -=1
            if counter[food] == 0: kind[0]-=1


    counter = {want[i]: number[i] for i in range(len(want))}
    kind = [len(want)]
    ans = 0

    for i in range(10):
        inc_dec(0, discount[i])
    if kind[0] == 0: ans+=1

    for i in range(len(discount)-10):
        inc_dec(1, discount[i])
        inc_dec(0, discount[i+10])
        if kind[0] == 0: ans+=1

    return ans