class Solution {
    public String solution(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder();
        char[] str = my_string.toCharArray();

        for (int i = 0; i < index_list.length; i++) {
            int idx = index_list[i];
            sb.append(str[idx]);
        }
        return sb.toString();
    }
}