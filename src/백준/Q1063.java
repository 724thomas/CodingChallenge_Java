// https://www.acmicpc.net/problem/
package 백준;

/*
1. 아이디어 :
-

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
맵,
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Q1063 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Map<String, int[]> dirs = new HashMap<>();
        dirs.put("R", new int[]{1,0});
        dirs.put("L", new int[]{-1,0});
        dirs.put("B", new int[]{0,-1});
        dirs.put("T", new int[]{0,1});
        dirs.put("RT", new int[]{1,1});
        dirs.put("LT", new int[]{-1,1});
        dirs.put("RB", new int[]{1,-1});
        dirs.put("LB", new int[]{-1,-1});

        String[] inputs = br.readLine().split(" ");
        String king = inputs[0], stone = inputs[1];
        int[] kCords = new int[]{ king.charAt(0) - 'A' + 1, Integer.parseInt(king.charAt(1)+"")};
        int[] sCords = new int[]{ stone.charAt(0) - 'A' + 1, Integer.parseInt(stone.charAt(1)+"")};


        int moves = Integer.parseInt(inputs[2]);
        int x1 = kCords[0], y1 = kCords[1], x2 = sCords[0], y2 = sCords[1];

        for (int i =0; i<moves; i++) {
            String input = br.readLine();
            int[] dir = dirs.get(input);
            int nx1 = x1 + dir[0], ny1 = y1 + dir[1];
            //격차 위 체크
            if (nx1<1 || 8<nx1 || ny1<1 || 8<ny1) continue;
            // 겹치는지 체크
            if (nx1 == x2 && ny1 == y2) {
                int nx2 = x2 + dir[0], ny2 = y2 + dir[1];
                if (nx2<1 || 8<nx2 || ny2<1 || 8<ny2) continue;
                x2 = nx2;
                y2 = ny2;
            }
            x1 = nx1;
            y1 = ny1;
        }

        king = (char)('A' + x1 - 1) + String.valueOf(y1);
        stone = (char)('A' + x2 - 1) + String.valueOf(y2);
        System.out.println(king);
        System.out.println(stone);
    }
}
