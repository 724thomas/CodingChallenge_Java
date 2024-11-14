# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];

            if (num % 2 == 0) {
                answer[i] = num + 1;
            } else {
                long bit = 1;
                while ((num & bit) != 0) { // 가장 낮은 0의 위치
                    bit *= 2;
                }
                answer[i] = num + bit - (bit / 2);
            }
        }

        return answer;
    }
}

'''



