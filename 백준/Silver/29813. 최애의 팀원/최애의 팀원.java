import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Student {
        String initial;
        int number;

        public Student(String initial, int number) {
            this.initial = initial;
            this.number = number;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Student> studentQueue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] studentInfo = br.readLine().split(" ");
            String initial = studentInfo[0];
            int number = Integer.parseInt(studentInfo[1]);
            studentQueue.offer(new Student(initial, number));
        }

        while(studentQueue.size() > 1) {
            Student first = studentQueue.poll();
            int number = first.number;
            for (int i = 0; i < number - 1; i++) {
                studentQueue.offer(studentQueue.poll());
            }
            studentQueue.poll();
        }
        System.out.println(studentQueue.remove().initial);
    }
}
