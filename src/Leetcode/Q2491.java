package Leetcode;

import java.util.Arrays;

public class Q2491 {
    class Solution {
        public long dividePlayers(int[] skill) {
            if (skill.length == 2) return skill[0] * skill[1];

            int n = skill.length;
            Arrays.sort(skill);
            long cmax = skill[0] + skill[skill.length-1];
            long ans = 0;
            for (int i=0; i<n/2; i++){
                if (skill[i] + skill[n-1-i] != cmax) return -1;
                ans+= skill[i] * skill[n-1-i];
            }
            return ans;
        }
    }
}
