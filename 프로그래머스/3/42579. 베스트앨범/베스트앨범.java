import java.util.*;

class Solution {
    class Genre {
        int play;
        PriorityQueue<Song> songQueue;

        public Genre(int play, PriorityQueue<Song> songQueue) {
            this.play = play;
            this.songQueue = songQueue;
        }
    }

    class Song {
        int num;
        int play;

        public Song(int num, int plays) {
            this.num = num;
            this.play = plays;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            Song song = new Song(i, plays[i]);
            String genreStr = genres[i];
            if (!map.containsKey(genreStr)) {
                PriorityQueue<Song> songQueue = new PriorityQueue<>((a, b) -> {
                    if (a.play == b.play) return a.num - b.num;
                    return b.play - a.play;
                });
                map.put(genreStr, new Genre(0, songQueue));
            }
            Genre genre = map.get(genreStr);
            genre.songQueue.add(song);
            genre.play += song.play;
        }

        PriorityQueue<Genre> genreQueue = new PriorityQueue<>(
                (a, b) -> b.play - a.play
        );
        for (Map.Entry<String, Genre> entry : map.entrySet()) {
            Genre genre = entry.getValue();
            genreQueue.add(genre);
        }

        List<Integer> list = new ArrayList<>();
        while (!genreQueue.isEmpty()) {
            Genre genre = genreQueue.poll();
            PriorityQueue<Song> songQueue = genre.songQueue;
            for (int cnt = 0; cnt < 2 && !songQueue.isEmpty(); cnt++) {
                Song song = songQueue.poll();
                list.add(song.num);
            }
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}