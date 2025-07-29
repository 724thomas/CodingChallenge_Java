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
import java.util.Arrays;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {


        String input = br.readLine();
        String[] inputs = br.readLine().split(" ");
        int[] ninputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();


    }
}
