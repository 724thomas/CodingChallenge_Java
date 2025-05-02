package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q241 {
    class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            List<Integer> candids = new ArrayList<>();
            boolean opFound = false;
            for (int i=0; i<expression.length(); i++) {
                char c = expression.charAt(i);
                if (c == '+' || c=='-' || c=='*') {
                    opFound = true;
                    //왼쪽에 나올 수 있는 결과들
                    List<Integer> leftside = diffWaysToCompute(expression.substring(0, i));
                    //오른쪽에 나올 수 있는 결과들
                    List<Integer> rightside = diffWaysToCompute(expression.substring(i+1));

                    for (int leftNum : leftside) for (int rightNum : rightside) {
                        if (c == '+') {
                            candids.add(leftNum + rightNum);
                        } else if (c == '-') {
                            candids.add(leftNum - rightNum);
                        } else if (c == '*') {
                            candids.add(leftNum * rightNum);
                        }
                    }
                }
            }

            if (!opFound) candids.add(Integer.parseInt(expression));

            return candids;
        }
    }
}
