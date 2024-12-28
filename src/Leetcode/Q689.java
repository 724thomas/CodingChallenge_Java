package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q689 {
    class Solution {
        Map<Integer, Integer> subArraySums = new HashMap<>();
        Map<String, Integer> dp = new HashMap<>();

        public void fillSubArraySums(int[] nums, int k) {
            int curr = 0;
            for (int i=0; i<k; i++) curr += nums[i];
            subArraySums.put(0, curr);
            for (int i=0; i<nums.length-k; i++) {
                curr +=  nums[i+k] - nums[i];
                subArraySums.put(i+1, curr);
            }
        }

        public int getMaxSum(int i, int count, int[] nums, int k) {
            if (count==3 || i > nums.length - k) return 0;

            String key = i + "-" + count;
            if (dp.containsKey(key)) return dp.get(key);

            int include = subArraySums.get(i) + getMaxSum(i+k, count+1, nums, k);
            int skip = getMaxSum(i+1, count, nums, k);

            dp.put(key, Math.max(include, skip));
            return dp.get(key);
        }

        public int[] getIndices(int[] nums, int k) {
            List<Integer> indices = new ArrayList<>();
            int i = 0;
            while (i <= nums.length - k && indices.size() < 3) {

                // i를 포함했을 때 얻을 수 있는 합
                int include = subArraySums.get(i) + getMaxSum(i + k, indices.size() + 1, nums, k);

                // i를 스킵했을 때 얻을 수 있는 합
                int skip = getMaxSum(i + 1, indices.size(), nums, k);

                if (include >= skip) {
                    indices.add(i);
                    i += k;  // 이 구간은 선택했으므로 k만큼 건너뜀
                } else {
                    i++;     // 스킵
                }
            }

            return indices.stream().mapToInt(Integer::intValue).toArray();
        }

        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            fillSubArraySums(nums, k);
            return getIndices(nums, k);
        }
    }
}
