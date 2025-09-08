package Leetcode.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Q353 {
    class SnakeGame {
        int[] head;
        Deque<int[]> body = new ArrayDeque<>();

        int rows;
        int cols;
        int[][] food;
        int foodIdx;

        Map<String, int[]> dirCord = new HashMap<>();

        public SnakeGame(int cols, int rows, int[][] food) {
            this.rows = rows;
            this.cols = cols;
            this.food = food;
            this.foodIdx = 0;
            head = new int[]{0,0};
            dirCord.put("R", new int[]{0, 1});
            dirCord.put("L", new int[]{0, -1});
            dirCord.put("U", new int[]{-1, 0});
            dirCord.put("D", new int[]{1, 0});
            body.add(head);
        }

        public int move(String direction) {
            int[] dCord = dirCord.get(direction);
            int dx = head[0] + dCord[0], dy = head[1] + dCord[1];


            if (!isValid(dx,dy)) return -1;

            boolean eaten = false;
            if (foodIdx < food.length && food[foodIdx][0] == dx && food[foodIdx][1] == dy) {
                foodIdx++;
                eaten= true;
            }

            body.addFirst(new int[]{dx, dy});
            if (!eaten) body.pollLast();

            head = new int[]{dx,dy};
            return body.size()-1;
        }

        public boolean isValid(int x, int y) {
            if (x<0 || x>=rows || y < 0 || y>=cols) return false;

            for (int[] b : body) {
                if (b[0] == x && b[1] == y && b!=body.getLast()) return false;
            }
            return true;
        }
    }

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
}
