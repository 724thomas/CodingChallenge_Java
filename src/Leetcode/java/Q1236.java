package Leetcode.java;

public class Q1236 {
/*

 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }


    class Solution {
        Set<String> visited = new HashSet<>();

        public String getHostUrl(String url) {
            return url.split("/")[2];
        }

        public List<String> crawl(String startUrl, HtmlParser htmlParser) {
            String hostUrl = getHostUrl(startUrl);
            Deque<String> deque = new ArrayDeque<>();
            deque.add(startUrl);
            visited.add(startUrl);

            while (!deque.isEmpty()) {
                String curr = deque.pollFirst();

                for (String neighbor : htmlParser.getUrls(curr)) {
                    if (visited.contains(neighbor) || !getHostUrl(neighbor).equals(hostUrl)) continue;
                    visited.add(neighbor);
                    deque.addLast(neighbor);
                }
            }
            return new ArrayList<>(visited);
        }
    }
 */
}
