// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Q27466 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]), m = Integer.parseInt(inputs[1]);
        String S = br.readLine();

        StringBuilder ans = new StringBuilder();
        for (int i=n-1; i>=0; i--){
            if (ans.length() == 0) {
                if (S.charAt(i) == 'A' || S.charAt(i) == 'E' || S.charAt(i) == 'I' || S.charAt(i) == 'O' || S.charAt(i) == 'U') continue;
                ans.append(S.charAt(i));
            } else if (ans.length() == 1 || ans.length() == 2) {
                if (S.charAt(i) == 'A') {
                    ans.append(S.charAt(i));
                }
            } else {
                ans.append(S.charAt(i));
            }
        }
        if (ans.length() >= m){
            System.out.println("YES");
            ans.reverse();
            System.out.println(ans.substring(ans.length()-m, ans.length()));
        } else {
            System.out.println("NO");
        }
    }
}
