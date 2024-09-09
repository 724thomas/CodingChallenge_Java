package Leetcode;

public class Q880 {
    public String decodeAtIndex(String inputString, int k) {
        long decodedLength = 0;

        for (char character : inputString.toCharArray()) {
            if (Character.isDigit(character)) {
                decodedLength *= (character - '0');
            } else {
                decodedLength++;
            }
        }

        //반대로 탐색
        for (int i = inputString.length() - 1; i >= 0; i--) {
            char currentChar = inputString.charAt(i);

            if (Character.isDigit(currentChar)) {
                // 숫자면, 길이와 k 갱신
                decodedLength /= (currentChar - '0');
                k %= decodedLength;
            } else {
                // 알파벳이면, k번째 캐릭터인지 확인
                if (k == 0 || decodedLength == k) {
                    return String.valueOf(currentChar);
                }
                decodedLength--;
            }
        }

        return "";
    }
}
