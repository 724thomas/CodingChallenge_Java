package Leetcode;

/*
1. 아이디어 :
knowledge를 map에 저장합니다. 같은 key가 들어오면 ?로 저장합니다.
s를 순회하면서 괄호가 열리는지 닫히는지 확인
- 열리면 isOpen을 true로 바꿉니다.
- 닫히면 isOpen을 false로 바꿉니다. curr을 map에서 key로 사용하여 value를 가져옵니다.

열린 상태에서는 curr에 추가, 닫힌 상태에서는 ans에 추가합니다.

2. 시간복잡도 :
O( n * m )

3. 자료구조/알고리즘 :
해시맵 / -
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1807 {
    class Solution {
        public String evaluate(String s, List<List<String>> knowledge) {
            Map<String, String> map = new HashMap<>();
            for (List<String> k : knowledge) {
                String key = k.get(0), val = k.get(1);
                map.put(key, map.containsKey(key)? "?" : val);
            }

            StringBuilder ans = new StringBuilder();
            StringBuilder curr = new StringBuilder();

            boolean isOpen = false;
            for (char c : s.toCharArray()) {
                if (c=='(') {
                    isOpen = true;
                } else if (c==')') {
                    isOpen = false;
                    String key = curr.toString();
                    ans.append(map.containsKey(key) ? map.get(key) : "?");
                    curr = new StringBuilder();
                } else {
                    if (!isOpen) {
                        ans.append(c);
                    } else {
                        curr.append(c);
                    }
                }
            }

            return ans.toString();
        }
    }
}
