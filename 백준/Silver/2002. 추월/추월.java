import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 맵에 들어간 차량들의 인덱스를 기록
        Map<String, Integer> map = new HashMap<>();
        String[] cars = new String[N];
        
        for (int i = 0; i < N; i++) {
            String enterCar = br.readLine();
            map.put(enterCar, i);
            cars[i] = enterCar;
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String exitCar = br.readLine();
            int beforeIdx = map.get(exitCar);
            if (i < beforeIdx) {
                String temp = cars[beforeIdx];
                for (int idx = beforeIdx; idx > i; idx--) {
                    cars[idx] = cars[idx - 1];
                    map.put(cars[idx], map.get(cars[idx]) + 1);
                }
                cars[i] = temp;
                map.put(exitCar, i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}