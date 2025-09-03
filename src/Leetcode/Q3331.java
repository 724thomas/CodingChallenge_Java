package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q3331 {
    class Solution {
        Map<Integer, List<Integer>> children;
        int n;
        int[] parent, size, newParent;
        String s;

        public int getSize(int node) {
            int totalSize = 1;

            for (int child : children.getOrDefault(node, new ArrayList<>())) {
                totalSize += getSize(child);
            }
            size[node] = totalSize;
            return totalSize;
        }

        public void findParent(int node, int[] pos) {
            char c = s.charAt(node);
            int prev = pos[c-'a'];

            if (pos[c-'a'] == -1) {
                newParent[node] = parent[node];
            } else {
                newParent[node] = prev;
            }
            pos[c-'a'] = node;
            for (int child : children.getOrDefault(node, new ArrayList<>())) {
                findParent(child, pos.clone());
            }
            pos[c-'a'] = prev;
        }

        public int[] findSubtreeSizes(int[] parent, String s) {
            this.parent = parent;
            this.s = s;
            n = parent.length;
            newParent = new int[n];
            for (int i=0; i<n; i++) newParent[i] = parent[i];

            children = new HashMap<>();
            for (int i=0; i<n; i++) {
                children.putIfAbsent(parent[i], new ArrayList<>());
                children.get(parent[i]).add(i);
            }

            int[] pos = new int[26];
            Arrays.fill(pos, -1);
            findParent(0, pos);

            size = new int[n];
            children = new HashMap<>();
            for (int i=0; i<n; i++) {
                children.putIfAbsent(newParent[i], new ArrayList<>());
                children.get(newParent[i]).add(i);
            }
            getSize(0);
            return size;
        }
    }
}
