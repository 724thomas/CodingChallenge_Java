package Leetcode;

public class Q2416 {
    class Solution {
        class Node {
            Node[] children;
            int count;

            public Node() {
                this.children = new Node[26]; // 26 letters for lowercase a-z
                this.count = 0;
            }
        }

        Node root;

        public void add_prefix(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
                curr.count++;
            }
        }

        public int count_score(String word) {
            Node curr = root;
            int ans = 0;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                curr = curr.children[idx];
                ans += curr.count;
            }
            return ans;
        }

        public int[] sumPrefixScores(String[] words) {
            int[] ans = new int[words.length];
            root = new Node();
            for (String word : words) {
                add_prefix(word);
            }

            for (int i=0; i<words.length; i++) {
                ans[i] = count_score(words[i]);
            }
            return ans;

        }
    }
}
