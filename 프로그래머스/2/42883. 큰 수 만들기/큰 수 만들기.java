class Solution {
    public String solution(String number, int k) {
        char[] numArray = number.toCharArray();

        int start = 0;
        int remain = number.length() - k;

        StringBuilder sb = new StringBuilder();
        while (remain > 0) {
            char max = 0;
            int maxIdx = -1;

            for (int i = start; i < number.length() - remain + 1; i++) {
                if (max < numArray[i]) {
                    max = numArray[i];
                    maxIdx = i;
                    if (max == '9') break;
                }
            }

            sb.append(max);
            start = maxIdx + 1;
            remain--;
        }
        return sb.toString();
    }
}