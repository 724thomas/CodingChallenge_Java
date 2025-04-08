package Leetcode;

/*
1. 아이디어 :
스택을 사용합니다.
스택이 3이상이고, 스택의 마지막 2개가 #이고, 스택의 마지막 3번째가 #이 아닐 경우, 스택에서 3개를 제거하고 #을 추가합니다.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
스택 / -
 */

import java.util.ArrayList;
import java.util.List;

public class Q331 {
    class Solution {
        public void check(List<String> stack) {
            while (stack.size() >= 3 &&
                    stack.get(stack.size()-1).equals("#") &&
                    stack.get(stack.size()-2).equals("#") &&
                    !stack.get(stack.size()-3).equals("#")) {
                stack.remove(stack.size()-1);
                stack.remove(stack.size()-1);
                stack.remove(stack.size()-1);
                stack.add("#");
            }
        }
        public boolean isValidSerialization(String preorder) {
            List<String> stack = new ArrayList<>();
            for (String s : preorder.split(",")) {
                check(stack);
                stack.add(s);
            }
            check(stack);

            return stack.size()==1 && stack.get(0).equals("#");
        }
    }
}
