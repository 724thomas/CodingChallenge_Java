package Leetcode;

/*
1. 아이디어 :
    브루트 포스

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / 브루트 포스
 */

import java.util.List;

public class Q1773 {
    class Solution {
        public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
            int ans = 0;
            for (List<String> item : items) {
                String type = item.get(0), color = item.get(1), name = item.get(2);
                if (ruleKey.equals("type")) {
                    if (ruleValue.equals(type)) ans++;
                } else if (ruleKey.equals("color")) {
                    if (ruleValue.equals(color)) ans++;
                } else {
                    if (ruleValue.equals(name)) ans++;
                }
            }
            return ans;
        }
    }
}
