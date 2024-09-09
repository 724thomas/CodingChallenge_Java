package Leetcode;

public class Q1328 {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1) return "";

        char[] parr = palindrome.toCharArray();
        for (int i=0; i<parr.length/2; i++) {
            if (parr[i] != 'a') {
                parr[i] = 'a';
                return String.valueOf(parr);
            }
        }

        parr[parr.length-1] = 'b';
        return String.valueOf(parr);
    }
}
