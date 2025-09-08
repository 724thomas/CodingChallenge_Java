package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.*;

public class Q1181 {
    class Pair {
        String start;
        String end;
        String phrase;
        int index;

        public Pair(String start, String end, String phrase, int index) {
            this.start = start;
            this.end = end;
            this.phrase = phrase;
            this.index = index;
        }
    }
    class Solution {
        public String addString(String[] aList, String b) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<aList.length-1; i++) {
                sb.append(aList[i] + " ");
            }
            sb.append(b);
            return sb.toString();
        }

        public List<String> beforeAndAfterPuzzles(String[] phrases) {
            Map<String, List<Pair>> starts = new HashMap<>();

            for (int i=0; i<phrases.length; i++) {
                String p = phrases[i];
                String[] ps = p.split(" ");
                String start = ps[0], end = ps[ps.length-1];

                starts.putIfAbsent(start, new ArrayList<>());
                starts.get(start).add(new Pair(start, end, p, i));
            }


            Set<String> candids = new HashSet<>();

            for (int i=0; i<phrases.length; i++) {
                String phrase = phrases[i];
                String[] wordList = phrase.split(" ");

                StringBuilder exceptLast = new StringBuilder();
                String endWord = wordList[wordList.length-1];
                List<Pair> startPairs = starts.getOrDefault(endWord, new ArrayList<>());
                if (startPairs.size() == 0) continue;
                for (int j=0; j<wordList.length-1; j++) {
                    exceptLast.append(wordList[j] + " ");
                }
                for (Pair pair : startPairs) {
                    if (i == pair.index) continue;
                    candids.add(exceptLast + pair.phrase);
                }
            }

            List<String> ans = new ArrayList<>();
            for (String candid : candids) ans.add(candid);
            Collections.sort(ans);
            return ans;
        }
    }
}
