# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    -
2. 시간복잡도 :
    O(    )
3. 자료구조 :
    -
class Solution {
    public int solution(String name) {
        int n = name.length();
        int moveCost = 0;
        int minMove = n - 1;

        for (int i = 0; i < n; i++) {
            char target = name.charAt(i);

            moveCost += Math.min(target - 'A', 'Z' - target + 1);

            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            // 1. 오른쪽으로 이동하다가 왼쪽으로 되돌아오기
            // 2. 왼쪽으로 이동하다가 오른쪽으로 되돌아오기
            minMove = Math.min(minMove, i * 2 + n - next);
            minMove = Math.min(minMove, (n - next) * 2 + i);
        }

        return moveCost + minMove;
    }
}

'''



