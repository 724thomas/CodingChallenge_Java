package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3481 {
    class Solution {
        Map<String, String> map = new HashMap<>();

        public String applySubstitutions(List<List<String>> replacements, String text) {
            for (List<String> r : replacements) map.put(r.get(0), r.get(1));
            return helper(text);
        }

        public String helper(String text) {
            StringBuilder ans = new StringBuilder();
            StringBuilder curr = new StringBuilder();
            boolean isOpen = false;
            for (char c : text.toCharArray()) {
                if (c == '%') {
                    if (isOpen) {
                        ans.append(helper(map.get(curr.toString())));
                        curr = new StringBuilder();
                    }
                    isOpen = !isOpen;
                }
                else if (isOpen) curr.append(c);
                else if (!isOpen) ans.append(c);
            }

            return ans.toString();
        }
    }
}
