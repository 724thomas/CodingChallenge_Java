package Leetcode.java;

public class Q2696 {
    class Solution {
        public int minLength(String s) {
            while (s.contains("AB") || s.contains("CD")) s= s.replace("AB","").replace("CD","");
            return s.length();
        }
    }
}
