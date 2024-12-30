package Leetcode;

public class Q2288 {
    class Solution {
        public String applyDiscount(String s, int discount) {
            double val = Long.parseLong(s);
            return "$" + String.format("%.2f", val * (1 - ((double) discount / 100)));
        }

        public String discountPrice(String s, int discount) {
            if (s.charAt(0) != '$') return s;

            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                } else {
                    return s;
                }
            }

            if (sb.length() == 0) return s;

            return applyDiscount(sb.toString(), discount);
        }

        public String discountPrices(String sentence, int discount) {
            StringBuilder sb = new StringBuilder();
            for (String s : sentence.split(" ")) {
                sb.append(discountPrice(s, discount)).append(" ");
            }

            return sb.toString().strip();
        }
    }
}
