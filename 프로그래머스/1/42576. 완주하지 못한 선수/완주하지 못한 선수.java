import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/42576
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < completion.length; i++) {
            map.computeIfPresent(completion[i], (s, val) -> val + 1);
            map.putIfAbsent(completion[i], 1);
        }

        String answer = "";

        for (int i = 0; i < participant.length; i++) {
            int cnt = map.getOrDefault(participant[i], 0);
            if (cnt == 0) {
                answer = participant[i];
                break;
            }
            map.computeIfPresent(participant[i], (s, val) -> val - 1);
        }
        return answer;
    }
}