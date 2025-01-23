package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q1656 {
    class OrderedStream {
        int idx;
        String[] values;
        public OrderedStream(int n) {
            values = new String[n+2];
            idx = 1;
        }

        public List<String> insert(int idKey, String value) {
            values[idKey] = value;
            List<String> ans = new ArrayList<>();
            while (values[idx]!=null) ans.add(values[idx++]);
            return ans;
        }
    }

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
}
