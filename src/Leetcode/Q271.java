package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;

public class Q271 {
    public class Codec {
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for (String s : strs) {
                sb.append(s.length()).append(":").append(s);
            }
            //5:Hello5:World
            return sb.toString();
        }

        public List<String> decode(String s) {
            List<String> result = new ArrayList<>();
            int i = 0;

            while (i < s.length()) {
                int colonIndex = s.indexOf(":", i);
                int length = Integer.parseInt(s.substring(i, colonIndex));
                i = colonIndex + 1;
                result.add(s.substring(i, i + length));
                i += length;
            }

            return result;
        }
    }

}
