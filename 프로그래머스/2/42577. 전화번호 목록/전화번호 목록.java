import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (String num : set) {
            for (int i = 1; i < num.length(); i++) {
                if (set.contains(num.substring(0,i))) return false;
            }
        }
        return true;
    }
}