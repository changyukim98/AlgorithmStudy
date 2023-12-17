import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// https://www.acmicpc.net/problem/10814
public class Main {
    static class Member {
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Member> memberList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int age = Integer.parseInt(inputs[0]);
            String name = inputs[1];
            memberList.add(new Member(age, name));
        }

        // Arrays.sort()는 퀵정렬 기반 -> 불안정정렬
        // Collections.sort()는 삽입정렬+합병정렬 -> 안정정렬
        memberList.sort(Comparator.comparingInt(a -> a.age));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            Member m = memberList.get(i);
            sb.append(m.age).append(' ').append(m.name).append('\n');
        }
        System.out.println(sb);
    }
}