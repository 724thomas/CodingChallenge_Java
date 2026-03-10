// https://www.acmicpc.net/problem/
package 백준;

/*
1. 아이디어 :
커서 기준 왼쪽 스택, 오른쪽 스택 사용

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
Stack
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map;

class Q1406 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int idx = s.length();

        Deque<Character> lStack = new ArrayDeque<>();
        Deque<Character> rStack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            lStack.addLast(c);
        }

        for (int i=0; i<n; i++) {
            String input = br.readLine();
            Character command = input.charAt(0);
            Character c = input.length()==1 ? null : input.charAt(2);

            if (command.equals('L')) {
                if (lStack.isEmpty()) continue;
                rStack.addLast(lStack.pollLast());
            } else if (command.equals('D')) {
                if (rStack.isEmpty()) continue;
                lStack.addLast(rStack.pollLast());
            } else if (command.equals('B')) {
                if (lStack.isEmpty()) continue;
                lStack.pollLast();
            } else if (command.equals('P')) {
                lStack.addLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!lStack.isEmpty()) sb.append(lStack.pollFirst());
        while (!rStack.isEmpty()) sb.append(rStack.pollLast());
        System.out.println(sb.toString());
    }
}
