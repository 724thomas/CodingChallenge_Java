# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> visited = new HashSet<>();
        visited.add(words[0]);

        for (int i=1; i<words.length; i++) {
            String prev = words[i-1], curr = words[i];
            if (prev.charAt(prev.length()-1) != curr.charAt(0) || visited.contains(curr)){
                return new int[]{i%n+1, i/n+1};
            }
            visited.add(curr);
        }

        return new int[]{0,0};
    }
}

'''


