package Leetcode.java;

import java.util.ArrayList;
import java.util.List;

public class Q604 {
    class StringIterator {
        int idx=0;
        List<Character> charList = new ArrayList<>();
        List<Integer> counter = new ArrayList<>();

        public StringIterator(String s) {
            StringBuilder count = new StringBuilder();
            count.append("0");

            for (int i=0; i<s.length(); i++) {
                if (Character.isAlphabetic(s.charAt(i))) {
                    charList.add(s.charAt(i));
                    counter.add(Integer.parseInt(count.toString()));
                    count = new StringBuilder();
                    count.append("0");
                } else {
                    count.append(s.charAt(i));
                }
            }
            counter.add(Integer.parseInt(count.toString()));
        }

        public char next() {
            if (!hasNext()) return ' ';

            if (counter.get(idx+1) > 0) {
                counter.set(idx + 1, counter.get(idx + 1) - 1);
                return charList.get(idx);
            } else {
                idx++;
                if (!hasNext()) return ' ';
                counter.set(idx + 1, counter.get(idx + 1) - 1);
                return charList.get(idx);
            }
        }

        public boolean hasNext() {
            if (idx >= charList.size()) return false;
            if (counter.get(idx + 1) > 0) return true;

            int tmp = idx + 1;
            while (tmp < charList.size()) {
                if (counter.get(tmp + 1) > 0) {
                    return true;
                }
                tmp++;
            }
            return false;
        }
    }

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
