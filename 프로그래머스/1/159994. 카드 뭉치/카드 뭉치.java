class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int now = 0, i = 0, j = 0;
        while (now < goal.length) {
            if (i < cards1.length && goal[now].equals(cards1[i])) i++;
            else if (j < cards2.length && goal[now].equals(cards2[j])) j++;
            else return "No";
            now++;
        }
        return "Yes";
    }
}