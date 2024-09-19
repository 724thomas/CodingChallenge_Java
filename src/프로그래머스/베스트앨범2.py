'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        Map<String, Integer> genrePlays = new HashMap<>();
        Map<String, ArrayList<int[]>> genreSongs = new HashMap<>();

        for (int i=0; i<n; i++) {
            String genre = genres[i];
            int play = plays[i];
            genrePlays.put(genre, genrePlays.getOrDefault(genre, 0) + play);

            genreSongs.putIfAbsent(genre, new ArrayList<>());
            genreSongs.get(genre).add(new int[]{i, play});
        }

        List<String> sortedGenres = new ArrayList<>(genrePlays.keySet());
        sortedGenres.sort((g1, g2) -> genrePlays.get(g2) - genrePlays.get(g1)); //desc
        ArrayList<Integer> album = new ArrayList<>();
        for (String genre : sortedGenres) {
            ArrayList<int[]> songs = genreSongs.get(genre);
            songs.sort((s1, s2) -> s1[1] == s2[1] ? s1[0] - s2[0] : s2[1] - s1[1]);

            for (int i=0; i<Math.min(2, songs.size()); i++) {
                album.add(songs.get(i)[0]);
            }
        }

        int[] ans = new int[album.size()];
        for (int i=0; i<album.size(); i++) {
            ans[i] = album.get(i);
        }
        return ans;
    }
}




'''


