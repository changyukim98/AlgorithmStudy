import java.util.*;

class Solution {
    List<String> list;
    public int solution(String word) {
        char[] alphabets = {'A', 'E', 'I', 'O', 'U'};
        
        list = new ArrayList<>();
        perm(alphabets, 0, "");
        
        return list.indexOf(word) + 1;
    }

    public void perm(char[] alphabets, int cur, String result) {
        if (cur != 0) list.add(result);
        if (cur == 5) return;
        
        for (int i = 0; i < 5; i++) {
            perm(alphabets, cur + 1, result + alphabets[i]);
        }
    }
}