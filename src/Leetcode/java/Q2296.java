package Leetcode.java;

/*
1. 아이디어 :
- Cursor를 기준으로 왼쪽과 오른쪽 두개의 Deque를 사용합니다.
- addText, deleteText는 leftCursor에 문자를 추가하거나 삭제합니다.
- cursorLeft, cursorRight는 이동할때마다,
  - leftCursor에서 오른쪽으로 이동하는 문자를 rightCursor로 옮기고,
  - rightCursor에서 왼쪽으로 이동하는 문자를 leftCursor로 옮깁니다.
  - getLast10은 leftCursor에서 최대 10개의 문자를 가져와서 반환합니다.

2. 시간복잡도 :
모두 O( n )

3. 자료구조/알고리즘 :
Deque / -
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Q2296 {
    class TextEditor {
        int cursorPos;
        Deque<Character> leftCursor;
        Deque<Character> rightCursor;
        Deque<Character> tempDeque;
        public TextEditor() {
            leftCursor = new ArrayDeque<>();
            rightCursor = new ArrayDeque<>();
            tempDeque = new ArrayDeque<>();
        }

        public void addText(String text) {
            for (char c : text.toCharArray()) {
                leftCursor.add(c);
            }
        }

        public int deleteText(int k) {
            int count = 0;
            for (int i=0; i<k; i++) {
                if (!leftCursor.isEmpty()) {
                    leftCursor.pollLast();
                    count++;
                }
            }
            return count;
        }

        public String cursorLeft(int k) {
            for (int i=0; i<k; i++) {
                if (!leftCursor.isEmpty()) {
                    rightCursor.addFirst(leftCursor.pollLast());
                }
            }
            return getLast10();
        }

        public String cursorRight(int k) {
            for (int i=0; i<k; i++) {
                if (!rightCursor.isEmpty()) {
                    leftCursor.addLast(rightCursor.pollFirst());
                }
            }
            return getLast10();
        }

        private String getLast10() {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<10; i++) {
                if (!leftCursor.isEmpty()) {
                    sb.append(leftCursor.peekLast());
                    tempDeque.addLast(leftCursor.pollLast());
                }
            }

            while (!tempDeque.isEmpty()) {
                leftCursor.addLast(tempDeque.pollLast());
            }

            return sb.reverse().toString();
        }
    }

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
}
