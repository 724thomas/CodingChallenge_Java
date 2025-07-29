// https://www.acmicpc.net/problem/
package 백준;

/*
1. 아이디어 :
TreeSet을 사용하면, 현재 위치와 인접한 다음 위치를 찾을 수 있습니다.

2. 시간복잡도 :
command1: O( 1 )
command2: O( 1 )
command3: O( logn )

3. 자료구조/알고리즘 :
트리셋 / 이진탐색
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q23326 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int q = Integer.parseInt(inputs[1]);

        TreeSet<Integer> popPlaces = new TreeSet<>();
        inputs = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            if (inputs[i].equals("1")) popPlaces.add(i);
        }

        int curr = 0;

        List<int[]> commands = new ArrayList<>();
        for (int i=0; i<q; i++) {
            commands.add(Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray());
        }

        for (int[] command : commands) {
            if (command[0] == 1) {
                command1(popPlaces, command[1]-1);
            } else if (command[0] == 2) {
                curr = command2(n, curr, command[1]);
            } else {
                command3(n, popPlaces, curr);
            }
        }

    }

    private static void command1(TreeSet<Integer> popPlaces, int idx) {
           if (popPlaces.contains(idx)) {
               popPlaces.remove(idx);
           } else {
               popPlaces.add(idx);
           }
    }

    private static int command2(int n, int curr, int moves) {
        moves = moves % n;
        curr = (curr + moves) % n;
        return curr;
    }

    private static void command3(int n, TreeSet<Integer> popPlaces, int curr) {
        if (popPlaces.isEmpty()) {
            System.out.println(-1);
            return;
        }

        if (popPlaces.ceiling(curr) == null) {
            int nextPopPlace = popPlaces.first();
            System.out.println((n - curr + nextPopPlace) % n);
        } else {
            int nextPopPlace = popPlaces.ceiling(curr);
            System.out.println(nextPopPlace - curr);
        }
    }
}
