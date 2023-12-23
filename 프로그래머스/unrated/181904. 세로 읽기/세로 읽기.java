class Solution {
    public String solution(String my_string, int m, int c) {
        char[] charArray = my_string.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (i % m == c - 1) sb.append(charArray[i]);
        }
        return sb.toString();
    }
}
