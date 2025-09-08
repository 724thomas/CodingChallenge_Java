package Leetcode.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q874 {
    class Solution {
        public char getDirection(int cmd, char d){
            if (d == 'L'){
                if (cmd == -1) return 'U';
                else if (cmd == -2) return 'D';
            } else if (d == 'R'){
                if (cmd == -1) return 'D';
                else if (cmd == -2) return 'U';
            } else if (d == 'U'){
                if (cmd == -1) return 'R';
                else if (cmd == -2) return 'L';
            } else if (d == 'D'){
                if (cmd == -1) return 'L';
                else if (cmd == -2) return 'R';
            }
            return 'A';
        }
        public int robotSim(int[] commands, int[][] obstacles) {
            Set<String> walls = new HashSet<>();
            for (int[] obstacle:obstacles) {
                walls.add(obstacle[0] + ", " + obstacle[1]);
            }

            Map<Character, int[]> directions = new HashMap<>();
            directions.put('L', new int[]{-1, 0});
            directions.put('R', new int[]{1, 0});
            directions.put('U', new int[]{0, 1});
            directions.put('D', new int[]{0, -1});

            int ans = 0;

            int x = 0, y =0;
            char d = 'U';
            for (int cmd : commands) {
                if (cmd == -1 || cmd == -2) {
                    d = getDirection(cmd, d);
                } else {
                    int[] cord = directions.get(d);
                    int dx = cord[0], dy = cord[1];
                    for (int i=0; i<cmd; i++){
                        if (walls.contains((x+dx) + ", " + (y+dy))){
                            break;
                        } else {
                            x+=dx;
                            y+=dy;
                        }
                    }
                    ans = Math.max(ans, x*x + y*y);
                }
            }
            return ans;
        }
    }
}
