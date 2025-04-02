package Leetcode;

/*
1. 아이디어 :
트라이 구조를 사용합니다

2. 시간복잡도 :
put: O( l ) (l: key의 길이)
search: O( l+n ) (l: prefix의 길이, n: key의 개수)

3. 자료구조/알고리즘 :
트라이 / -
 */

import java.util.HashMap;
import java.util.Map;

public class Q677 {
    class Node {
        Map<String, Integer> childVals;
        Map<Character, Node> childNodes;

        public Node() {
            childVals = new HashMap<>();
            childNodes = new HashMap<>();
        }

        public void putVals(String s, int idx, int val) {
            childVals.put(s, val);

            if (idx < s.length()) {
                char c = s.charAt(idx);
                childNodes.putIfAbsent(c, new Node());
                childNodes.get(c).putVals(s, idx+1, val);
            }
        }

        public Map<String, Integer> search(String s, int idx) {
            if (idx == s.length()) return this.childVals;
            char c = s.charAt(idx);
            if (!childNodes.containsKey(c)) return new HashMap<>();
            return childNodes.get(c).search(s, idx+1);
        }
    }

    class MapSum {
        Map<String, Integer> map;
        Node root;

        public MapSum() {
            map = new HashMap<>();
            root = new Node();
        }

        public void insert(String key, int val) {
            map.put(key, val);
            root.putVals(key, 0, val);
        }

        public int sum(String prefix) {
            Map<String, Integer> map = root.search(prefix, 0);
            int total = 0;
            for (int val : map.values()) {
                total += val;
            }
            return total;
        }
    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
}
