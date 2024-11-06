# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :


import java.util.*;
class Solution {
    public String fullBinary(long number) {
        String binary = Long.toString(number, 2);
        int length = binary.length();
        int totalLength = 1;
        while (totalLength < length) totalLength = totalLength * 2 + 1;

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<totalLength - length; i++) sb.append("0");
        sb.append(binary);
        return sb.toString();
    }

    /*
    public boolean[] isPossible(String bin) {
        //exist, possible
        if (bin.length() == 1) {
            return new boolean[]{bin.charAt(0) == '1', true};
        }

        int n = bin.length();
        boolean parent = bin.charAt(n / 2) == '1';
        boolean[] left = isPossible(bin.substring(0, n/2));
        boolean[] right = isPossible(bin.substring(n/2 +1, n));

        if (!left[1] || !right[1]) {
            return new boolean[]{parent || left[0] || right[0] ,false};
        }
        if (!parent && left[0] || !parent && right[0]) {
            return new boolean[]{parent || left[0] || right[0] ,false};
        }
        return new boolean[]{parent || left[0] || right[0], true};
    }
    */

    public boolean isPossible(String bin) {
        int n = bin.length();
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, n - 1});

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            int left = range[0], right = range[1], mid = (left + right) / 2;

            boolean parent = bin.charAt(mid) == '1';

            if (left != mid) stack.push(new int[]{left, mid - 1});
            if (mid != right) stack.push(new int[]{mid + 1, right});

            if (!parent) {
                boolean leftTree = mid != left;
                boolean leftParent = bin.charAt((left + mid - 1) / 2) == '1';
                boolean rightTree = mid != right;
                boolean rightParent = bin.charAt((mid + 1 + right) / 2) == '1';
                if ((leftParent && leftTree) || (rightParent && rightTree)) return false;
            }
        }
        return true;
    }

    public int[] solution(long[] numbers) {
        int n = numbers.length;
        int[] ans = new int[n];
        for (int i=0; i<n; i++){
            String toFullBin = fullBinary(numbers[i]);
            // System.out.println(toFullBin);
            ans[i] = isPossible(toFullBin) ? 1 : 0;
        }
        // System.out.println(Arrays.toString(ans));
        return ans;
    }
}
'''


def solution(numbers):
    def fullbinary(number):
        binary = bin(number)[2:]
        length = len(binary)
        totallength = 1
        while totallength < length:
            totallength = totallength * 2 + 1

        ans = ""
        for i in range(totallength - length):
            ans += "0"
        return ans + binary

    def is_possible(bin):
        n = len(bin)
        stack = []
        stack.append([0, n - 1])

        while stack:
            left, right = stack.pop()
            mid = (left + right) // 2

            parent = bin[mid] == '1'

            if left != mid:
                stack.append([left, mid - 1])
            if mid != right:
                stack.append([mid + 1, right])

            if not parent:
                if (mid != left and bin[(left + mid - 1) // 2] == '1') or (mid != right and bin[(mid + 1 + right) // 2] == '1'):
                    return False
        return True

    n = len(numbers)
    ans = []
    for i in range(n):
        if is_possible(fullbinary(numbers[i])):
            ans.append(1)
        else:
            ans.append(0)
    return ans
