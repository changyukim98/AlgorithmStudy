import java.util.*;

// https://leetcode.com/problems/path-crossing/description/?envType=daily-question&envId=2023-12-23
class Solution {
    private int[] dy = {-1, 1, 0, 0};
    private int[] dx = {0, 0, 1, -1};
    public boolean isPathCrossing(String path) {
        int nowY = 0, nowX = 0;
        Map<Integer, Set<Integer>> setMap = new HashMap<>();

        int[] a;
        setMap.put(0, new HashSet<>(List.of(0)));
        for (int i = 0; i < path.length(); i++) {
            int d = -1;
            char direction = path.charAt(i);

            switch (direction) {
                case 'N' -> d = 0;
                case 'S' -> d = 1;
                case 'E' -> d = 2;
                case 'W' -> d = 3;
            }
            nowY += dy[d];
            nowX += dx[d];

            if (!setMap.containsKey(nowY)) setMap.put(nowY, new HashSet<>());
            Set<Integer> set = setMap.get(nowY);
            if (set.contains(nowX)) return true;
            set.add(nowX);
        }
        return false;
    }
}