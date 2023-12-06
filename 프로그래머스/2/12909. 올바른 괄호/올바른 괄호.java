import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        boolean answer = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
            } else {
                if (st.isEmpty()) {
                    answer = false;
                    break;
                } else if (st.pop() != '(') {
                    answer = false;
                    break;
                }
            }
        }
        if (!st.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}