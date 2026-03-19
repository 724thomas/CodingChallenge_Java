// https://www.acmicpc.net/problem/
package 백준;

/*
1. 아이디어 :
- path를 출력하기 때문에 모든 경로를 탐색(bfs)
- queue에 path를 모두 저장하다보면 메모리 초과 가능성
- command[]에 path를, prev[]에 이전 값을 저장하고 방문 처리
- start -> target 도착하면 역으로 계산

2. 시간복잡도 :
O( cases * 10000 )

3. 자료구조/알고리즘 :
bfs
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q9019 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] prev;
    static char[] command;
    static Deque<Integer> queue;

    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(br.readLine());
        for (int i=0; i<cases; i++) {
            String[] inputs =  br.readLine().split(" ");
            int start =  Integer.parseInt(inputs[0]), target = Integer.parseInt(inputs[1]);

            prev = new int[10000];
            Arrays.fill(prev, -1);
            command = new char[10000];
            queue = new ArrayDeque<>();

            queue.add(start);
            prev[start] = start;

            while (!queue.isEmpty()) {
                int curr = queue.pollFirst();
                if (curr == target) break;

                int numD = commandD(curr);
                int numS = commandS(curr);
                int numL = commandL(curr);
                int numR = commandR(curr);

                if (prev[numD] == -1) doCommand(curr, numD,'D');
                if (prev[numS] == -1) doCommand(curr, numS,'S');
                if (prev[numL] == -1) doCommand(curr, numL,'L');
                if (prev[numR] == -1) doCommand(curr, numR,'R');
            }

            StringBuilder sb = new StringBuilder();
            int curr = target;

            while (curr != start) {
                sb.append(command[curr]);
                curr = prev[curr];
            }
            System.out.println(sb.reverse().toString());
        }
    }

    public static void doCommand(int curr, int nextNum, char commandChar) {
        prev[nextNum] = curr;
        command[nextNum] = commandChar;
        queue.addLast(nextNum);
    }

    public static int commandD(int num) {
        return (num * 2) % 10_000;
    }

    public static int commandS(int num) {
        return (num + 10_000 - 1) % 10_000;
    }

    public static int commandL(int num) {
        return (num % 1_000) * 10 + (num / 1_000);
    }

    public static int commandR(int num) {
        return (num % 10) * 1000 + (num / 10);
    }
}
