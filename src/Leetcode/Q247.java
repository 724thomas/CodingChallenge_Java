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

public class Q247 {
    class Solution {

        public List<String> dfs(int remain, int total) {
            if (remain==0) return new ArrayList<>(Arrays.asList(""));
            if (remain==1) return new ArrayList<>(Arrays.asList("0","1","8"));

            List<String> smallerNums = dfs(remain-2, total);
            List<String> ans = new ArrayList<>();

            for (String num : smallerNums) {
                if (remain != total) ans.add("0" + num + "0");
                ans.add("1" + num + "1");
                ans.add("6" + num + "9");
                ans.add("8" + num + "8");
                ans.add("9" + num + "6");
            }
            return ans;
        }


        public List<String> findStrobogrammatic(int n) {
            return dfs(n, n);
        }
    }
}
