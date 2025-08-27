// https://www.acmicpc.net/problem/
package 백준;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q4781 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int toInt(String s) {
        s = s.trim();
        String[] parts = s.split("\\.");

        int intPart = Integer.parseInt(parts[0]) * 100;
        int decimalPart = Integer.parseInt(parts[1]);
        return intPart + decimalPart;
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = toInt(inputs[1]);
            if (n == 0 && m == 0) break;

            List<int[]> candies = new ArrayList<>();
            for (int i=0; i<n; i++) {
                inputs = br.readLine().split(" ");
                int calorie = Integer.parseInt(inputs[0]);
                int price = toInt(inputs[1]);
                if (price > m) continue;
                candies.add(new int[]{calorie, price});
            }

            int[] dp = new int[m+1]; // dp[i] : i 가격으로 얻을 수 있는 최대 칼로리
            Arrays.fill(dp, -1);
            dp[0] = 0;

            int ans = 0;
            for (int money=0; money<m; money++) {
                if (dp[money] == -1) continue;
                for (int[] candy : candies) {
                    int candyCalorie = candy[0], candyPrice = candy[1];
                    if (money + candyPrice > m) continue;
                    dp[money + candyPrice] = Math.max(dp[money+candyPrice], dp[money] + candyCalorie);
                    ans = Math.max(ans, dp[money + candyPrice]);
                }
            }
//        System.out.println(Arrays.toString(dp));
            System.out.println(ans);
        }

    }
}
