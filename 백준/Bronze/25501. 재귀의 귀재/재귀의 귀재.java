import java.util.Scanner;

public class Main {
    public static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        for (int t = 0; t < T; t++) {
            String S = sc.nextLine();
            cnt = 0;
            System.out.println(isPalindrome(S) + " " + cnt);
        }
    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }

    public static int recursion(String s, int l, int r) {
        cnt++;
        if (l >= r) return 1;
        else if (s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l + 1, r - 1);
    }
}