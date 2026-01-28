package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q622 {
    class MyCircularQueue {
        int[] queue;
        int front, end;
        int size;
        int k;
        public MyCircularQueue(int k) {
            queue = new int[k];
            front = 0;
            end = 0;
            this.k = k;
            size = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;

            queue[end] = value;
            end = (end+1) % k;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;

            front = (front+1) % k;
            size--;
            return true;
        }

        public int Front() {
            if (isEmpty()) return -1;
            return queue[front];
        }

        public int Rear() {
            if (isEmpty()) return -1;
            int lastIndex = (end - 1 + k) % k;
            return queue[lastIndex];
        }

        public boolean isEmpty() {
            return size==0;
        }

        public boolean isFull() {
            return size == k;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
