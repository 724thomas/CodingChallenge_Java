package Leetcode.java;

/*
1. 아이디어 :
    0과 1로 시작하여,
    순차적으로 앞에 0을 붙인 값들과 역순차적으로 앞에 1을 붙인 것들을 합쳐주게되면 비트가 1씩 차이나게 된다.

2. 시간복잡도 :
O( 2**n )

3. 자료구조/알고리즘 :
배열 / 백트래킹
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q89 {
    class Solution {
    /*
    0, 1
    00, 01,   11, 10
    000, 001, 011, 010,  110, 111, 101, 100
    0000, 0001, 0011, 0010, 0110, 0111, 0101, 0100,   1100, 1101, 1111, 1110, 1010, 1011, 1001, 1000
    */

        public List<Integer> grayCode(int n) {
            List<String> candids = backtrack(n);
            List<Integer> ans = new ArrayList<>();

            for (String candid : candids) {
                ans.add(Integer.valueOf(candid, 2));
            }
            return ans;
        }

        private List<String> backtrack(int n) {
            if (n == 1) return new ArrayList<>(Arrays.asList("0", "1"));

            List<String> prev = backtrack(n - 1);
            List<String> curr = new ArrayList<>();

            for (int i=0; i<prev.size(); i++) {
                curr.add("0" + prev.get(i));
            }
            for (int i = prev.size() - 1; i >= 0; i--) {
                curr.add("1" + prev.get(i));
            }

            return curr;
        }
    }

}
