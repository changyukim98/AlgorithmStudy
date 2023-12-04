class Solution {
    public String[] solution(String[] names) {
        int cnt = 0;
        String[] answer = new String[(names.length + 4) / 5];
        for (int i = 0; i < names.length; i += 5) {
            answer[cnt++] = names[i]; 
        }
        return answer;
    }
}