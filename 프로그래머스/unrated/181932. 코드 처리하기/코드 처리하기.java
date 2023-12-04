class Solution {
    public String solution(String code) {
        int mode = 0;
        StringBuilder ret = new StringBuilder();

        for (int idx = 0; idx < code.length(); idx++) {
            if (mode == 0) {
                if (code.charAt(idx) == '1') {
                    mode = 1;
                } else {
                    if (idx % 2 == 0) {
                        ret.append(code.charAt(idx));
                    }
                }
            } else if (mode == 1) {
                if (code.charAt(idx) == '1') {
                    mode = 0;
                } else {
                    if (idx % 2 == 1) {
                        ret.append(code.charAt(idx));
                    }
                }
            }
        }

        String answer = ret.toString();
        if (answer.isEmpty()) answer = "EMPTY";
        return answer;
    }
}