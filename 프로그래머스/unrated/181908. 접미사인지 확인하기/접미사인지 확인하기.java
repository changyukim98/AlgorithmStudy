class Solution {
    public int solution(String my_string, String is_suffix) {
        int strLen = my_string.length();
        int sufLen = is_suffix.length();

        if (strLen < sufLen) return 0;
        for (int i = 0; i < sufLen; i++) {
            if (my_string.charAt(strLen - 1 - i) 
                != is_suffix.charAt(sufLen - 1 - i)) {
                return 0;
            }
        }
        return 1;
    }
}