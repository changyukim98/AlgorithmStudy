public class Solution {
    public int solution(String s) {
        int strLen = s.length();
        int answer = strLen;

        for (int i = 1; i <= strLen / 2; i++) {
            int j = i;
            int repeat = 1;
            StringBuilder compStr = new StringBuilder();
            String preStr = s.substring(0, i);

            while (true) {
                if (j + i > strLen) {
                    stringSave(compStr, preStr, repeat);
                    stringSave(compStr, s.substring(j), 1);
                    break;
                }
                String nextStr = s.substring(j, j + i);
                if (preStr.equals(nextStr)) {
                    repeat++;
                } else {
                    stringSave(compStr, preStr, repeat);
                    repeat = 1;
                    preStr = nextStr;
                }
                j += i;
            }

            answer = Math.min(answer, compStr.length());
        }
        return answer;
    }

    public void stringSave(StringBuilder compStr, String preStr, int repeat) {
        if (repeat == 1) {
            compStr.append(preStr);
        } else {
            compStr.append(repeat).append(preStr);
        }
    }
}