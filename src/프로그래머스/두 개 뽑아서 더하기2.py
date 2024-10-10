# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;

public class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                resultSet.add(numbers[i] + numbers[j]);
            }
        }

        List<Integer> resultList = new ArrayList<>(resultSet);
        Collections.sort(resultList);

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}

'''


def solution(numbers):
    ans = set()
    for i in range(len(numbers)):
        for j in range(i+1, len(numbers)):
            ans.add(numbers[i] + numbers[j])
    return sorted(list(ans))
