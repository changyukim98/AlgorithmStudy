import java.util.Scanner;

public class Main {
    public static int[] arr, arr2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N + 1];
        arr2 = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int m = 0; m < M; m++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            reverseArr(arr, i, j);
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void reverseArr(int[] arr, int from, int to) {
        for (int i = to, j = from; i >= from; i--) {
            arr2[j++] = arr[i];
        }

        for (int i = from; i <= to; i++) {
            arr[i] = arr2[i];
        }
    }
}
