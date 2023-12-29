import java.util.*;

class Solution {
    Set<String> set = new HashSet<>();

    public int solution(String word) {
        char[] alphabets = {'A', 'E', 'I', 'O', 'U'};
        
        perm(alphabets, 0, "");
        set.remove("");
        
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) return i + 1;
        }
        return -1;
    }

    public void perm(char[] alphabets, int cur, String result) {
        if (cur == 5) {
            set.add(result);
            return;
        }
        for (int i = 0; i < 5; i++) {
            perm(alphabets, cur + 1, result + alphabets[i]);
        }
        perm(alphabets, cur + 1, result);
    }
}