package Leetcode;

public class Q348 {
    class TicTacToe {
        private int[] rows;
        private int[] cols;
        private int posDiag;
        private int negDiag;
        private int n;
        private int winner;

        public TicTacToe(int n) {
            this.n = n;
            rows = new int[n];
            cols = new int[n];
            posDiag = 0;
            negDiag = 0;
            winner = 0;
        }

        public int move(int row, int col, int player) {
            if (winner != 0) return winner;

            int add = (player == 1) ? 1 : -1;

            rows[row] += add;
            cols[col] += add;

            if (row == col) posDiag += add;
            if (row + col == n - 1) negDiag += add;

            if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n ||
                    Math.abs(posDiag) == n || Math.abs(negDiag) == n) {
                winner = player;
                return player;
            }

            return 0;
        }
    }

}
