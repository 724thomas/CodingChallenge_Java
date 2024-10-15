# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;

class Solution {
    Deque<String> deque = new LinkedList<>();
    Set<String> cache = new HashSet<>();

    public String preprocess(String city) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < city.length(); i++) {
            char c = city.charAt(i);
            if (c != ' ') {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return 5 * cities.length;

        int ans = 0;

        for (String city : cities) {
            city = preprocess(city);

            if (cache.contains(city)) {
                ans += 1;
                deque.remove(city);
                deque.addLast(city);
            } else {
                ans += 5;
                if (deque.size() >= cacheSize) cache.remove(deque.poll());
                deque.addLast(city);
                cache.add(city);
            }
        }

        return ans;
    }
}


'''

from collections import deque
def solution(cacheSize, cities):
    if cacheSize == 0:
        return 5 * len(cities)

    cache = deque()
    access_time = 0
    city_list = [city.lower() for city in cities]
    for city in city_list:
        if city in cache:
            access_time += 1
            cache.remove(city)
            cache.append(city)
        else:
            access_time += 5
            if len(cache) >= cacheSize:
                cache.popleft()
            cache.append(city)
    return access_time
