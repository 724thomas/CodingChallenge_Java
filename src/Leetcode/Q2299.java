package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.Set;

public class Q2299 {
    class Solution {
        public boolean strongPasswordCheckerII(String password) {
            Set<Character> specials = new HashSet<>();
            for (char c: "!@#$%^&*()-+".toCharArray()) specials.add(c);
            if (password.length() < 8) return false;
            boolean upper = false, lower = false, digit = false, special = false;
            for (char c : password.toCharArray()) {
                if (Character.isLowerCase(c)) lower = true;
                if (Character.isUpperCase(c)) upper = true;
                if (Character.isDigit(c)) digit = true;
                if (specials.contains(c)) special = true;
            }
            if (!upper || !lower || !digit || !special) return false;

            for (int i=0; i<password.length()-1; i++) {
                if (password.charAt(i) == password.charAt(i+1)) return false;
            }

            return true;
        }
    }
}
