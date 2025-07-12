package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q3581 {
    class Solution {
        public int countOddLetters(int n) {
            Map<Integer, String> convert = new HashMap<>();
            convert.put(0,"zero");
            convert.put(1,"one");
            convert.put(2,"two");
            convert.put(3,"three");
            convert.put(4,"four");
            convert.put(5,"five");
            convert.put(6,"six");
            convert.put(7,"seven");
            convert.put(8,"eight");
            convert.put(9,"nine");

            int[] counter = new int[26];
            while (n >= 1) {
                int remain = n%10;
                for (char c : convert.get(remain).toCharArray()) counter[c-'a']++;
                n = n/10;
            }
            int ans = 0;
            for (int count : counter) if (count%2==1) ans++;
            return ans;
        }
    }
}
