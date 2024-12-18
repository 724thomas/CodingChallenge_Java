# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    -
2. 시간복잡도 :
    O(    )
3. 자료구조 :
    -
import java.util.*;
class Solution {
    int[] discounts = new int[]{10,20,30,40};
    int U;
    int E;
    int[] ans = new int[]{-1, -1}; //users, sales


    public List<List<Integer>> combinations = new ArrayList<>();

    public void backtrack(List<Integer> curr) {
        if (curr.size() == E) {
            combinations.add(new ArrayList<>(curr));
            return;
        }

        for (int discount: discounts) {
            curr.add(discount);
            backtrack(curr);
            curr.remove(curr.size()-1);
        }
    }

    public int[] getSalesPerUser(List<Integer> combination, int[] emoticons, int ratio, int cost) {
        int sales = 0;
        for (int i=0; i<E; i++) {
            int discount = combination.get(i);
            if (discount >= ratio) sales += emoticons[i] * ((double)(100-discount) / 100);
            if (sales >= cost) return new int[]{1,0};
        }
        return new int[]{0, sales};
    }

    public void getUsersAndSales(List<Integer> combination, int[] emoticons, int[][] users) {
        int signups = 0;
        int total = 0;

        for (int j=0; j<users.length; j++) {
            int[] combResult = getSalesPerUser(combination, emoticons, users[j][0], users[j][1]);
            signups += combResult[0];
            total += combResult[1];
        }
        if (signups > ans[0]) {
            ans[0] = signups;
            ans[1] = total;
        } else if (signups == ans[0] && total > ans[1]) {
            ans[1] = total;
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {
        U = users.length;
        E = emoticons.length;

        backtrack(new ArrayList<>());
        // System.out.println(combinations);

        for (List<Integer> combination : combinations) {
            getUsersAndSales(combination, emoticons, users);
        }

        return ans;
    }
}
'''



