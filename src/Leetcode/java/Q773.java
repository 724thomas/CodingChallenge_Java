package Leetcode.java;

import java.util.*;

public class Q773 {
    class Solution {
        int[][] target = { {1, 2, 3}, {4, 5, 0} };
        int[][] dirs = { {0, 1}, {0, -1}, {-1, 0}, {1, 0} };

        public String boardToString(int[][] board) {
            StringBuilder sb = new StringBuilder();
            for (int[] row : board) {
                for (int cell : row) {
                    sb.append(cell);
                }
            }
            return sb.toString();
        }

        public int[][] stringToBoard(String s) {
            int[][] board = new int[2][3];
            for (int i = 0; i < s.length(); i++) {
                board[i / 3][i % 3] = s.charAt(i) - '0';
            }
            return board;
        }

        public List<String> move(String boardStr) {
            int[][] board = stringToBoard(boardStr);
            List<String> candid = new ArrayList<>();
            int[] cord0 = find0(board);
            int x = cord0[0], y = cord0[1];

            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= 2 || ny < 0 || ny >= 3) continue;

                int[][] newBoard = stringToBoard(boardStr);
                int temp = newBoard[x][y];
                newBoard[x][y] = newBoard[nx][ny];
                newBoard[nx][ny] = temp;

                candid.add(boardToString(newBoard));
            }
            return candid;
        }

        public int[] find0(int[][] board) {
            for (int row = 0; row < 2; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board[row][col] == 0) {
                        return new int[] { row, col };
                    }
                }
            }
            return new int[] { -1, -1 };
        }

        public int slidingPuzzle(int[][] board) {
            String targetStr = boardToString(target);
            String startStr = boardToString(board);

            if (startStr.equals(targetStr)) return 0;

            Set<String> visited = new HashSet<>();
            Deque<String> queue = new ArrayDeque<>();
            queue.addLast(startStr);
            visited.add(startStr);

            int steps = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String current = queue.pollFirst();
                    if (current.equals(targetStr)) return steps;

                    for (String next : move(current)) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.addLast(next);
                        }
                    }
                }
                steps++;
            }

            return -1;
        }
    }

}
