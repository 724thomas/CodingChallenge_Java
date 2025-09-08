package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q3606 {
    class Pair {
        String code;
        String businessLine;
        boolean isActive;

        public Pair(String code, String businessLine, boolean isActive) {
            this.code = code;
            this.businessLine = businessLine;
            this.isActive = isActive;
        }

        public boolean allCheck() {
            return isActive && check1() && check2();
        }

        public boolean check1() {
            String code = this.code;
            if (code.isEmpty()) return false;
            for (char c : code.toCharArray()) {
                int ch = (int)c;
                if (
                        (97<=ch && ch<=122) ||
                                (65<=ch && ch<=90) ||
                                (48<=ch && ch<=57) ||
                                ch == 95
                ) {
                } else {
                    return false;
                }
            }
            return true;
        }

        public boolean check2() {
            String businessLine = this.businessLine;
            if (businessLine.equals("electronics") ||
                    businessLine.equals("grocery") ||
                    businessLine.equals("pharmacy") ||
                    businessLine.equals("restaurant")
            ) {
                return true;
            }
            return false;
        }

    }
    class Solution {

        public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
            int n = code.length;
            List<Pair> temp = new ArrayList<>();
            for (int i=0; i<n; i++) {
                Pair pair = new Pair(code[i], businessLine[i], isActive[i]);
                if (pair.allCheck()) {
                    temp.add(pair);
                }
            }
            Collections.sort(temp, (a, b)-> {
                if (a.businessLine.equals(b.businessLine)) return a.code.compareTo(b.code);
                return a.businessLine.compareTo(b.businessLine);
            });

            List<String> ans = new ArrayList<>();
            for (Pair pair:temp) {
                ans.add(pair.code);
            }

            return ans;
        }
    }
}
