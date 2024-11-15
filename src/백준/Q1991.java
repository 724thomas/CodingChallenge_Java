// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    암기
2. 시간복잡도 :
    O( n )
3. 자료구조 :
    해시맵

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Q1991 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String input;
    static String[] inputs;
    static int[] ninputs;

    static Map<String, String[]> tree;

    static String root = "A";

    static StringBuilder sb;

    static public void preOrder(String node) {
        if (node.equals(".")) return;

        sb.append(node);
        preOrder(tree.get(node)[0]);
        preOrder(tree.get(node)[1]);
    }
    static public void inOrder(String node) {
        if (node.equals(".")) return;

        inOrder(tree.get(node)[0]);
        sb.append(node);
        inOrder(tree.get(node)[1]);
    }
    static public void postOrder(String node) {
        if (node.equals(".")) return;

        postOrder(tree.get(node)[0]);
        postOrder(tree.get(node)[1]);
        sb.append(node);
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        tree = new HashMap<>();
        for (int i=0; i<n; i++) {
            inputs = br.readLine().split(" ");
            tree.put(inputs[0], new String[]{inputs[1], inputs[2]});
        }
        sb = new StringBuilder();
        preOrder(root);
        System.out.println(sb.toString());

        sb = new StringBuilder();
        inOrder(root);
        System.out.println(sb.toString());

        sb = new StringBuilder();
        postOrder(root);
        System.out.println(sb.toString());
    }
}
