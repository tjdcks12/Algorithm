package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Question1759 {
    static int L;
    static int C;
    static char[] alphabet;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        alphabet = new char[C];

        for (int i = 0; i < C; i++) {
            alphabet[i] = sc.next().charAt(0);
        }

        Arrays.sort(alphabet);


        solve(0, "");
    }

    public static void solve(int idx, String password) {
        if (password.length() == L && check(password)) {
            System.out.println(password);
            return;
        }

        if (idx >= C) return;

        solve(idx + 1, password + alphabet[idx]);
        solve(idx + 1, password);
    }

    public static boolean check(String password) {
        int ja = 0;
        int mo = 0;

        for (int i = 0; i < password.length(); i++) {
            char tmp = password.charAt(i);
            if (tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 'u') mo++;
            else ja++;
        }

        return (mo >= 1 && ja >= 2);
    }
}
