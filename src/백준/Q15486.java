package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q15486 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int totalDays = Integer.parseInt(br.readLine());
        int[][] courses = new int[totalDays + 1][2];
        for (int i = 1; i <= totalDays; i++) courses[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[totalDays + 2];

        for (int day = 1; day <= totalDays; day++) {
            dp[day] = Math.max(dp[day], dp[day - 1]);

            int dur = courses[day][0], price = courses[day][1];
            int endDay = day + dur;

            if (endDay > totalDays + 1) continue;
            dp[endDay] = Math.max(dp[endDay], dp[day] + price);
        }

        int ans = Math.max(dp[totalDays], dp[totalDays + 1]);
        System.out.println(ans);
    }
}
