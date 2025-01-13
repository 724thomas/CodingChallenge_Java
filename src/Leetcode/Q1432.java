package Leetcode;

public class Q1432 {
    class Solution {

        public int maxDiff(int num) {
            char[] maxChars = String.valueOf(num).toCharArray();
            for (int i=0; i<maxChars.length; i++) {
                if (maxChars[i] != '9') {
                    char target = maxChars[i];
                    for (int j=0; j<maxChars.length; j++) {
                        if (maxChars[j] == target) {
                            maxChars[j] = '9';
                        }
                    }
                    break;
                }
            }
            int a = Integer.parseInt(new String(maxChars));

            char[] minChars = String.valueOf(num).toCharArray();
            if (minChars[0] != '1') {
                char target = minChars[0];
                for (int i=0; i<minChars.length; i++) {
                    if (minChars[i] == target) {
                        minChars[i] = '1';
                    }
                }
            } else { // 1
                for (int i=1; i<minChars.length; i++) {
                    if (minChars[i] != '0' && minChars[i] != '1') {
                        char target = minChars[i];
                        for (int j=1; j<minChars.length; j++) {
                            if (minChars[j] == target) {
                                minChars[j] = '0';
                            }
                        }
                        break;
                    }
                }
            }
            int b = Integer.parseInt(new String(minChars));

            return a-b;
        }
    }
}
