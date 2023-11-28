import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int len = s.length();
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        for (int i = 0; i < len; i++) {
            // 소문자 아스키코드 97(a)~122(z)
            int c = s.charAt(i) - 97;
            if (arr[c] == -1) arr[c] = i;
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}