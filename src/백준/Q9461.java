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
import java.util.HashMap;
import java.util.Map;

class Q9461 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<Integer, Long> cache = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(br.readLine());

        for (int i=0; i<cases; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dfs(n));
        }
    }

    public static long dfs(int n) {
        if (n == 1 || n == 2 || n == 3) return 1;
        if (cache.containsKey(n)) return cache.get(n);

        long length = dfs(n-3) + dfs(n-2);
        cache.put(n, length);
        return length;
    }
}
