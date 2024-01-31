import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Integer[] arr = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(arr);

        int cnt = 0;
        int front = 0, rear = arr.length - 1;
        while (front <= rear) {
            if (arr[front] + arr[rear] <= limit) {
                front++;
                rear--;
            } else {
                rear--;
            }
            cnt++;
        }
        return cnt;
    }
}