package Leetcode;

/*
1. 아이디어 :
- 왼쪽 숫자가 오른쪽 숫자보다 크면 끝 숫자와 첫쨰 숫자가 만난다. 이 경우가 두번 발생할 경우 -1을 리턴
- 가장 작은 숫자의 인덱스를 찾아서 n에서 빼준다.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / -
 */

import java.util.List;

public class Q2855 {
    class Solution {
        public int minimumRightShifts(List<Integer> nums) {
            int n= nums.size();
            boolean checked = false;
            for (int i=0; i<n; i++) {
                if (nums.get(i % n) > nums.get((i+1) % n)) {
                    if (checked) return -1;
                    checked = true;
                }
            }

            int idx = -1, cmin = Integer.MAX_VALUE;
            for (int i=0; i<n; i++) {
                if (nums.get(i) < cmin) {
                    cmin = nums.get(i);
                    idx = i;
                }
            }

            return (n-idx)%n;
        }
    }
}
