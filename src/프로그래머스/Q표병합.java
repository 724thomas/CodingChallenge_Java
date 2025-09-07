package 프로그래머스;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q표병합 {

    class Solution {
        List<String> ansList = new ArrayList<>();

        Map<String, String> par = new HashMap<>();
        Map<String, Integer> rank = new HashMap<>();
        Map<String, String> value = new HashMap<>();

        private String find(String x) {
            if (!x.equals(par.get(x))) {
                par.put(x, find(par.get(x)));
            }
            return par.get(x);
        }

        private String union(String a, String b) {
            String ra = find(a);
            String rb = find(b);

            if (ra.equals(rb)) return ra;

            if (rank.get(ra) > rank.get(rb)) {
                par.put(rb, ra);
                return ra;
            } else if (rank.get(ra) < rank.get(rb)) {
                par.put(ra, rb);
                return rb;
            } else {
                par.put(rb, ra);
                rank.put(ra, rank.get(ra) + 1);
                return ra;
            }
        }

        public void update(String r, String c, String newValue) {
            String cell = (Integer.parseInt(r) - 1) + "-" + (Integer.parseInt(c) - 1);
            String root = find(cell);
            value.put(root, newValue);
        }

        public void change(String oldValue, String newValue) {
            for (String key : value.keySet()) {
                if (value.get(key).equals(oldValue)) {
                    value.put(key, newValue);
                }
            }
        }

        public void merge(String r1, String c1, String r2, String c2) {
            String cell1 = (Integer.parseInt(r1) - 1) + "-" + (Integer.parseInt(c1) - 1);
            String cell2 = (Integer.parseInt(r2) - 1) + "-" + (Integer.parseInt(c2) - 1);
            String ra = find(cell1);
            String rb = find(cell2);

            if (!ra.equals(rb)) {
                String root = union(cell1, cell2);
                if (!value.get(ra).isEmpty()) {
                    value.put(root, value.get(ra));
                } else if (!value.get(rb).isEmpty()) {
                    value.put(root, value.get(rb));
                } else {
                    value.put(root, "");
                }
            }
        }

        public void unmerge(String r, String c) {
            String cell = (Integer.parseInt(r) - 1) + "-" + (Integer.parseInt(c) - 1);
            String root = find(cell);
            String prevValue = value.get(root);

            List<String> children = new ArrayList<>();
            for (Map.Entry<String, String> entry : par.entrySet()) {
                if (find(entry.getKey()).equals(root)) {
                    children.add(entry.getKey());
                }
            }

            for (String child : children) {
                par.put(child, child);
                value.put(child, "");
            }
            value.put(cell, prevValue);
        }

        public void print(String row, String col) {

            String cell = (Integer.parseInt(row) - 1) + "-" + (Integer.parseInt(col) - 1);
            String root = find(cell);

            if (value.get(root).equals("")) {
                ansList.add("EMPTY");
            } else {
                ansList.add(value.get(root));
            }
        }

        public String[] solution(String[] commands) {
            //초기화
            for (int row = 0; row < 50; row++) {
                for (int col = 0; col < 50; col++) {
                    String cell = row + "-" + col;
                    par.put(cell, cell);
                    rank.put(cell, 1);
                    value.put(cell, "");
                }
            }


            for (String command : commands) {
                String[] cmd = command.split(" ");
                if (cmd[0].equals("UPDATE") && cmd.length == 4) {
                    update(cmd[1], cmd[2], cmd[3]);

                } else if (cmd[0].equals("UPDATE") && cmd.length == 3) {
                    change(cmd[1], cmd[2]);

                } else if (cmd[0].equals("MERGE")) {
                    merge(cmd[1], cmd[2], cmd[3], cmd[4]);

                } else if (cmd[0].equals("UNMERGE")) {
                    unmerge(cmd[1], cmd[2]);

                } else if (cmd[0].equals("PRINT")) {
                    print(cmd[1], cmd[2]);
                }
            }

            String[] ans = new String[ansList.size()];
            for (int i=0; i<ansList.size(); i++) ans[i] = ansList.get(i);
            return ans;
        }
    }

}
