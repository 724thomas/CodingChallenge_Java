// https://www.acmicpc.net/problem/
package 백준;

/*

1. 아이디어 :
    그래프를 사용하여 인접한 노드들을 관리합니다.
    루트부터 탐색을 시작하면서 자싟들을 큐에 넣고 정답을 갱신합니다.
2. 시간복잡도 :
    O( n )
3. 자료구조 :
    해시맵, 해시셋

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String input;
    static String[] inputs;
    static int[] ninputs;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        Set<Integer> visited = new HashSet<>();
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i=0; i<n-1; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]), b = Integer.parseInt(inputs[1]);
            graph.putIfAbsent(a, new HashSet<>());
            graph.putIfAbsent(b, new HashSet<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }


        int[] ans = new int[n+1];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        visited.add(1);

        while (!deque.isEmpty()) {
            int curr = deque.pollFirst();
            for (int connectedNode : graph.get(curr)) {
                if (visited.contains(connectedNode)) continue;
                visited.add(connectedNode);
                deque.addLast(connectedNode);
                ans[connectedNode] = curr;
            }
        }
        for (int i=2; i<=n; i++) {
            System.out.println(ans[i]);
        }
    }
}
