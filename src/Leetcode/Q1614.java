package Leetcode;

/*
1. 아이디어 :
스택을 사용해서 풀 수 있습니다.
다만, 스택보다는 count가 메모리 효율적이기떄문에 count 사용
순회하면서 "("를 만나면 count를 늘려주고, ")"를 만나면 count를 줄여줍니다.
추가로, "("의 갯수를 갱신합니다.


2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
문자열 / -
 */

public class Q1614 {
    class Solution {
        public int maxDepth(String s) {
            int ans = 0, count = 0;
            for (char c : s.toCharArray()) {
                if (c=='(') {
                    count++;
                } else if (c==')') {
                    count--;
                }
                ans = Math.max(ans, count);
            }
            return ans;
        }
    }
}
