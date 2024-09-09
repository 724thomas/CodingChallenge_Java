package Leetcode;

public class Q29 {
    public int divide(int dividend, int divisor) {
        // Overflow 처리 (Integer.MIN_VALUE / -1)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;

        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            int multiple = 1;

            while (absDividend >= tempDivisor + tempDivisor) {
                tempDivisor += tempDivisor;
                multiple += multiple;
            }

            absDividend -= tempDivisor;
            quotient += multiple;
        }

        return (dividend > 0) == (divisor > 0) ? quotient : -quotient;
    }
}
