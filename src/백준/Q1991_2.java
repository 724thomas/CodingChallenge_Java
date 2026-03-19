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

class Q1991_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static Map<String, String[]> map = new HashMap<>();
    static String root = "A";

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++){
            String[] inputs = br.readLine().split(" ");
            map.putIfAbsent(inputs[0], new String[]{inputs[1], inputs[2]});
        }

        System.out.println(preOrder(root));
        System.out.println(inOrder(root));
        System.out.println(postOrder(root));
    }

    public static String preOrder(String curr) {
        if (curr.equals(".")) return "";

        StringBuilder sb = new StringBuilder();
        String left = preOrder(map.get(curr)[0]);
        String right = preOrder(map.get(curr)[1]);

        sb.append(curr).append(left).append(right);
        return sb.toString();
    }

    public static String inOrder(String curr) {
        if (curr.equals(".")) return "";

        StringBuilder sb = new StringBuilder();
        String left = inOrder(map.get(curr)[0]);
        String right = inOrder(map.get(curr)[1]);

        sb.append(left).append(curr).append(right);
        return sb.toString();
    }

    public static String postOrder(String curr) {
        if (curr.equals(".")) return "";

        StringBuilder sb = new StringBuilder();
        String left = postOrder(map.get(curr)[0]);
        String right = postOrder(map.get(curr)[1]);

        sb.append(left).append(right).append(curr);
        return sb.toString();
    }
}
