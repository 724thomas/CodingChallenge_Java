package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2241 {
    class Candid {
        int remain = 0;
        int[] counter = new int[5];

        public Candid(int remain, int[] counter) {
            this.remain = remain;
            this.counter= counter;
        }
    }
    class ATM {
        int[] counter;
        int[] dollar;
        public ATM() {

            counter = new int[5];
            dollar = new int[]{20,50,100,200,500};
        }

        public void deposit(int[] banknotesCount) {
            for (int i=0; i<5; i++) {
                counter[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int[] used = new int[5];
            int remain = amount;

            for (int i=4; i>=0; i--) {
                int can = Math.min(counter[i], remain/dollar[i]);
                if (can > 0) {
                    used[i] = can;
                    remain -= can * dollar[i];
                }
            }

            if (remain != 0) {
                return new int[]{-1};
            }

            for (int i=0; i<5; i++) {
                counter[i] -= used[i];
            }
            return used;
        }

        public void decrease(int[] counter, int[] ans) {
            for (int i=0; i<5; i++) {
                counter[i] -= ans[i];
            }
        }
    }

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
}
