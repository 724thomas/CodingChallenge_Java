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

class Q24391 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] par;

    private static int find(int a) {
        if (par[a] != a) par[a] = find(par[a]);
        return par[a];
    }

    private static void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return;
        par[rb] = ra;
    }

    public static void main(String[] args) throws IOException {
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]), m = Integer.parseInt(inputs[1]);

        par = new int[n+1];
        for (int i=1; i<n+1; i++) par[i] = i;
        for (int i=0; i<m; i++) {
            inputs = br.readLine().split(" ");
            int u = Integer.parseInt(inputs[0]), v = Integer.parseInt(inputs[1]);
            union(u, v);
        }

        int ans = 0;
        inputs = br.readLine().split(" ");
        for (int i=0; i<n-1; i++) {
            int u = Integer.parseInt(inputs[i]), v = Integer.parseInt(inputs[i+1]);
            if (find(u) != find(v)) ans++;
        }

        System.out.println(ans);
    }
}
