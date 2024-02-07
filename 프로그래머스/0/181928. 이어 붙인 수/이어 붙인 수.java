class Solution {
    public int solution(int[] num_list) {
        int evenNums = 0;
        int oddNums = 0;

        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 0) evenNums = (evenNums * 10) + num_list[i];
            else oddNums = (oddNums * 10) + num_list[i];
        }

        return evenNums + oddNums;
    }
}