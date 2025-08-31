package 프로그래머스;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int left = 0, right = 0, total = 0;

        int bestLen = Integer.MAX_VALUE;
        int[] ans = new int[2];

        while (true) {
            if (total >= k) {
                if (total == k) {
                    if (right - left < bestLen) {
                        bestLen = right - left;
                        ans[0] = left;
                        ans[1] = right - 1;
                    }
                }
                total -= sequence[left++];
            } else {
                if (right == n) break;
                total += sequence[right++];
            }
        }

        return ans;
    }
}
