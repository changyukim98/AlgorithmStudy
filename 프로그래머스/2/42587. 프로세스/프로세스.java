import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // 프로세스의 우선순위와 초기 location을 저장할 클래스 생성
    static class Process {
        int priority;
        int location;

        public Process(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }

    public static int solution(int[] priorities, int location) {
        // 프로세스들을 담을 큐 생성
        Queue<Process> processQueue = new LinkedList<>();

        // 우선순위와 초기 location을 담은 Process를 생성해 큐에 넣음
        for (int i = 0; i < priorities.length; i++) {
            Process p = new Process(priorities[i], i);
            processQueue.add(p);
        }
        // 우선순위 최댓값을 뒤에서부터 확인하는 용도로 정렬
        Arrays.sort(priorities);

        // 작업을 진행할 때마다 더 해줄 변수
        int cnt = 0;
        // 우선순위 최대값을 확인하기 위한 변수
        int idx = priorities.length - 1;
        while (!processQueue.isEmpty()) {
            // 현재 프로세스를 꺼내기
            int nowPriority = processQueue.peek().priority;
            int nowLocation = processQueue.peek().location;

            // 현재 프로세스의 우선순위가 최대값일 경우
            if (nowPriority == priorities[idx]) {
                cnt++;
                idx--;
                // 작업을 완료하므로 프로세스 제거
                processQueue.remove();
                // 만약 이 프로세스가 구하고자 했던 프로세스일 경우
                if (nowLocation == location) break;
            } else {
                // 이번 프로세스는 작업하면 안되므로 큐의 뒤에 다시 삽입
                processQueue.add(processQueue.poll());
            }
        }

        return cnt;
    }
}