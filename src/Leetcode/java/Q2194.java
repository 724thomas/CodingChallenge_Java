package Leetcode.java;

/*
1. 아이디어 :
부르트 포스 방식으로 주어진 범위의 셀을 순회하면서 각 셀의 좌표를 문자열로 만들어 리스트에 추가합니다.

2. 시간복잡도 :
O( row difference * column difference )

3. 자료구조/알고리즘 :
- / 부르트 포스

 */

import java.util.ArrayList;
import java.util.List;

public class Q2194 {
    class Solution {
        public List<String> cellsInRange(String s) {
            List<String> ans = new ArrayList<>();
            char rStart = s.charAt(0), rEnd = s.charAt(3);
            char cStart = s.charAt(1), cEnd = s.charAt(4);
            for (char row=rStart; row<=rEnd; row++) for (char col = cStart; col<=cEnd; col++) {
                ans.add(row+""+col);
            }
            return ans;
        }
    }
}
