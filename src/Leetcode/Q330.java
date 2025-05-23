package Leetcode;

/*
1. 아이디어 :
그리디.
cmax는 현재 만들 수 있는 최대 숫자.
nums를 순회하면서, 현재 만들 수 있는 최대 숫자가 num보다 작으면, cmax+1을 만들 수 있는 숫자 추가. 반복.
모든 nums를 순회해도, n보다 작으면, cmax+1을 만들 수 있는 숫자 추가. 반복.

2. 시간복잡도 :
O(log n) n = Integer.MAX_VALUE이고, 2배씩 증가.

3. 자료구조/알고리즘 :
- / 그리디
 */

public class Q330 {
    class Solution {
        public int minPatches(int[] nums, int n) {
            int ans = 0;
            long cmax = 0;
            for (int num: nums) {
                while (cmax+1 < num) {
                    if(cmax>=n) break;
                    cmax += cmax+1;
                    ans++;
                }
                cmax += num;
            }

            while (cmax < n) {
                cmax+= cmax+1;
                ans++;
            }
            return ans;
        }
    }
}
