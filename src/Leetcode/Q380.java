package Leetcode;

/*
1. 아이디어 :
삭제시:
- 삭제할 숫자의 인덱스를 찾는다.
- 삭제할 숫자의 인덱스에 마지막 숫자를 넣는다.
- 마지막 숫자의 인덱스를 삭제할 숫자의 인덱스로 업데이트한다.
- 마지막 숫자를 삭제한다.

2. 시간복잡도 :
O( 1 ) // insert, remove

3. 자료구조/알고리즘 :
해시맵 / -

 */

import java.util.*;

public class Q380 {
    class Dummy {
        int val;
        public Dummy(int val) {
            this.val = val;
        }
    }

    class RandomizedSet {
        Random rand = new Random();
        Map<Integer, Integer> numToIndex;
        List<Dummy> dummyList = new ArrayList<>();

        public RandomizedSet() {
            numToIndex = new HashMap<>();
        }

        public boolean insert(int val) {
            if (!numToIndex.containsKey(val)) {
                Dummy dum = new Dummy(val);
                numToIndex.put(val, dummyList.size());
                dummyList.add(dum);
                return true;
            }
            return false;
        }

        public boolean remove(int val) {
            if (numToIndex.containsKey(val)) {
                int idx = numToIndex.get(val);

                dummyList.get(idx).val = dummyList.get(dummyList.size()-1).val;

                int lastVal = dummyList.get(dummyList.size()-1).val;
                numToIndex.put(lastVal, idx);
                numToIndex.remove(val);

                dummyList.remove(dummyList.size()-1);
                return true;
            }
            return false;
        }

        public int getRandom() {
            int randIdx = rand.nextInt(dummyList.size());
            return dummyList.get(randIdx).val;
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
