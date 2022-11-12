package kr.co.programmers.school;
//https://school.programmers.co.kr/learn/courses/30/lessons/120885


public class 이진수_더하기 {
    public String solution(String bin1, String bin2) {
        return Integer.toBinaryString((Integer.parseInt(bin1,2)+(Integer.parseInt(bin2,2))));
    }
}


