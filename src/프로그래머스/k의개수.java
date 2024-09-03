package 프로그래머스;
//k의 개수
//https://school.programmers.co.kr/learn/courses/30/lessons/120887
public class k의개수 {
    public int solution(int i, int j, int k) {
        int count=0;
        String temp="";
        for(int a=i; a<j+1; a++){
            temp+=String.valueOf(a);
        }
        for(int a=0; a<temp.length(); a++){
            if((Integer.parseInt(temp.charAt(a)+""))==k){
                count++;
            }
        }
        return count;
    }
}
