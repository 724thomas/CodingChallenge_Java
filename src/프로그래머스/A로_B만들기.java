//https://school.programmers.co.kr/learn/courses/30/lessons/120886
package 프로그래머스;

public class A로_B만들기 {
    public int solution(String before, String after) {
        if (sortString(before).equals(sortString(after))){
            return 1;
    }
        return 0;
    }

    public String sortString(String str) {
        str = str.chars()        // IntStream
                .sorted()
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
        return str;
    }
}