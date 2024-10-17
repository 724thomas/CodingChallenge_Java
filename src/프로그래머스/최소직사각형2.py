# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int maxHeight = 0, maxWidth = 0;
        int height, width;
        for (int[] size : sizes) {
            if (size[0] < size[1]) {
                height = size[0];
                width = size[1];
            } else {
                height = size[1];
                width = size[0];
            }
            maxHeight = Math.max(maxHeight, height);
            maxWidth = Math.max(maxWidth, width);
        }
        return maxHeight * maxWidth;
    }
}

'''


def solution(sizes):
    max_width = 0;
    max_height = 0;

    for width, height in sizes:
        if width < height:
            width, height = height, width
        max_height = max(max_height, height)
        max_width = max(max_width, width)
    return max_height * max_width;