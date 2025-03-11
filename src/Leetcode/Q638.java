package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q638 {
    public class Solution {
        Map<List<Integer>, Integer> map = new HashMap<>();
        List<Integer> price;
        List<List<Integer>> special;

        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            this.price = price;
            this.special = special;
            return shopping(needs);
        }

        public int shopping(List<Integer> needs) {
            if (map.containsKey(needs))return map.get(needs);

            int j = 0, ans = getTotal(needs, price);

            for (List<Integer> s : special) {
                ArrayList<Integer> clone = new ArrayList<>(needs);
                for (j = 0; j < needs.size(); j++) {
                    int diff = clone.get(j) - s.get(j);
                    if (diff < 0) break;
                    clone.set(j, diff);
                }
                if (j == needs.size()) {
                    int specialCost = s.get(j);
                    ans = Math.min(ans, specialCost + shopping(clone));
                }

            }
            map.put(needs, ans);
            return ans;
        }

        public int getTotal(List<Integer> a, List<Integer> b) {
            int sum = 0;
            for (int i = 0; i < a.size(); i++) {
                sum += a.get(i) * b.get(i);
            }
            return sum;
        }

    }
}
