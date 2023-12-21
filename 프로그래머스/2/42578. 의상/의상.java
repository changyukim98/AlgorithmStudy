import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            int cnt = map.getOrDefault(clothes[i][1], 0);
            map.put(clothes[i][1], cnt + 1);
        }

        int result = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result *= entry.getValue() + 1;
        }
        result -= 1;
        
        return result;
    }
}