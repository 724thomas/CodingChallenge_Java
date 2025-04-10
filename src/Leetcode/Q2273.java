package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2273 {
    class Solution {
        public List<String> removeAnagrams(String[] words) {
            int n = words.length;
            List<String> ans = new ArrayList<>();
            ans.add(words[0]);
            for (int i=1; i<n; i++) {
                char[] last = ans.get(ans.size()-1).toCharArray();
                Arrays.sort(last);
                String lastWord = new String(last);

                char[] chars = words[i].toCharArray();
                Arrays.sort(chars);
                String nword = new String(chars);
                if (lastWord.equals(nword)) continue;

                ans.add(words[i]);
            }
            return ans;
        }
    }
}
