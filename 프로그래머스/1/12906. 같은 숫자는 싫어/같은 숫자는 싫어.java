import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (list.isEmpty()) {
                list.add(arr[i]);
            } else {
                int top = list.get(list.size() - 1);
                if (top == arr[i]) continue;
                list.add(arr[i]);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}