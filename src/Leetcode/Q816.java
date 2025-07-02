package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q816 {
    class Solution {
        String s2;
        public List<String> backtrack(String s) {
            List<String> candids = new ArrayList<>();
            int n = s.length();

            // 소수점 아닌 경우
            if (s.equals("0")) candids.add("0"); //0일 경우
            else if (s.charAt(0) != '0') candids.add(s);//맨 앞이 0이 아닌 경우
            else if (s.length() == 1) candids.add(s);//1자리수일 경우

            // 소수점 경우
            for (int i=1; i<n; i++) {
                String left = s.substring(0, i);
                String right = s.substring(i);
                if ((left.equals("0") || left.charAt(0) != '0') && !right.endsWith("0")) {
                    // left는 0이거나 맨앞이 0이 아니고, right는 0으로 끝나지 않는 경우
                    candids.add(left + "." + right);
                }
            }
            return candids;
        }
        public List<String> ambiguousCoordinates(String s) {
            s2 = s.substring(1, s.length()-1);
            int n = s2.length();
            List<String> ans = new ArrayList<>();

            for (int i=1; i<n; i++) {
                String left = s2.substring(0, i);
                String right = s2.substring(i);

                List<String> lCandids = backtrack(left);
                List<String> rCandids = backtrack(right);
                for (String a : lCandids) for (String b : rCandids) {
                    ans.add("(" + a + ", " + b + ")");
                }
            }
            return ans;
        }
    }
}
