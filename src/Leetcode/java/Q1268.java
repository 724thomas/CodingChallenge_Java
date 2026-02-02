package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q1268 {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> suggestions = new ArrayList<>(3);
    }

    class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode node = root;

            for (char c : word.toCharArray()) {
                int idx = c - 'a';

                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }

                node = node.children[idx];

                if (node.suggestions.size() < 3) {
                    node.suggestions.add(word);
                }
            }
        }
    }

    class Solution {
        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Arrays.sort(products);

            Trie trie = new Trie();
            for (String product : products) {
                trie.insert(product);
            }

            List<List<String>> result = new ArrayList<>();
            TrieNode node = trie.root;

            for (char c : searchWord.toCharArray()) {
                if (node != null) {
                    node = node.children[c-'a'];
                }

                if (node == null) {
                    result.add(Collections.emptyList());
                } else {
                    result.add(node.suggestions);
                }
            }

            return result;
        }
    }
}
