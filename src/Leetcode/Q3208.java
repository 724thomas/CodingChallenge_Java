package Leetcode;

/*
1. 아이디어 :
투포인터를 사용합니다.
left는 마지막 같은 색갈이 나온 인덱스, right는 현재 인덱스입니다.
right를 순회하면서 같은 색깔이 나오면 left를 right로 옮깁니다.
right-left+1이 k보다 크거나 같으면 그룹을 만들 수 있습니다.

2. 시간복잡도 :
O( 2n )

3. 자료구조/알고리즘 :
- / 투 포인터
 */

public class Q3208 {
    class Solution {
        public int numberOfAlternatingGroups(int[] colors, int k) {
            int n = colors.length;
            int[] ncolors = new int[n*2];
            for (int i=0; i<n; i++) {
                ncolors[i] = colors[i];
                ncolors[n+i] = colors[i];
            }

            int ans = 0;
            int left = 0;
            for (int right=0; right<n + k -1; right++) {
                if (right>0 && ncolors[right] == ncolors[right-1]) {
                    left = right;
                }

                if (right-left+1>=k) {
                    ans++;
                }
            }


            return ans;
        }
    }
}
