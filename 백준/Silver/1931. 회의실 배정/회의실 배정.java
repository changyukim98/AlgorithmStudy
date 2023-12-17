import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Meeting> timeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            timeList.add(new Meeting(start, end));
        }
        // 종료시간을 오름차순으로 정렬
        // 종료시간이 같다면 시작시간을 오름차순으로 정렬
        // 시작시간을 정렬하지 않으면 시작과 종료가 같은경우 예외 발생 가능 
        timeList.sort((a, b) -> {
            if (a.end == b.end) return a.start - b.start;
            return a.end - b.end;
        });

        int now = -1;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            Meeting m = timeList.get(i);
            if (m.start >= now) {
                now = m.end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
