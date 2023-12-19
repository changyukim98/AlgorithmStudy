class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        int now = numLog[0];

        for (int i = 1; i < numLog.length; i++) {
            switch (numLog[i] - now) {
                case -10 -> sb.append('a');
                case -1 -> sb.append('s');
                case 1 -> sb.append('w');
                case 10 -> sb.append('d');
            }
            now = numLog[i];
        }
        return sb.toString();
    }
}