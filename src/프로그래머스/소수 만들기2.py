'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public HashSet<Integer> get_primes(int n){
        var primes = new HashSet<Integer>();
        if (n<2) return primes;

        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i=2; i<=n; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j=i+i; j<=n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        return primes;
    }


    public int solution(int[] nums) {
        int n = nums.length;
        int total = Arrays.stream(nums).sum();
        var candid = get_primes(total);
        var count = 0;
        for (int i=0; i<n - 2; i++) {
            for (int j=i+1; j<n-1; j++) {
                for (int k=j+1; k<n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (candid.contains(sum)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}



'''


