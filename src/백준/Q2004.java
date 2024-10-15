// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q2004 {
    static String input;
    static String[] inputs;
    static int[] ninputs;

    public static int countFactor ( int n, int factor){
        int count = 0;
        while (n>=factor) {
            count += n/factor;
            n/=factor;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n! / m! * (n-m)!
        ninputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int a = ninputs[0];
        int b = ninputs[1];
        int c = a - b;

        int[] aTwoFive = new int[]{countFactor(a, 2), countFactor(a,5)};
        int[] bTwoFive = new int[]{countFactor(b, 2), countFactor(b,5)};
        int[] cTwoFive = new int[]{countFactor(c, 2), countFactor(c,5)};
        int twos = aTwoFive[0] - bTwoFive[0] - cTwoFive[0];
        int fives = aTwoFive[1] - bTwoFive[1] - cTwoFive[1];
        System.out.println(Math.min(twos, fives));
    }
}
