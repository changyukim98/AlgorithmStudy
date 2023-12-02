public class Solution {
    public String solution(String s) {
        String answer;
        s = s.toLowerCase();

        char[] text = s.toCharArray();
        boolean isFirst = true;

        for (int i = 0; i < text.length; i++) {
            if (isFirst && Character.isLowerCase(text[i])) {
                text[i] = Character.toUpperCase(text[i]);
                isFirst = false;
            } else if (text[i] == ' ') {
                isFirst = true;
            } else {
                isFirst = false;
            }
        }
        answer = String.valueOf(text);
        return answer;
    }
}