import java.util.HashMap;
import java.util.Map;

class Solution {

    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }


        for (String calling : callings) {
            int playerIdx = map.get(calling);
            String rearPlayer = players[playerIdx];
            String frontPlayer = players[playerIdx - 1];

            map.replace(rearPlayer, playerIdx - 1);
            map.replace(frontPlayer, playerIdx);

            String temp = players[playerIdx - 1];
            players[playerIdx - 1] = players[playerIdx];
            players[playerIdx] = temp;
        }
        
        return players;
    }
}