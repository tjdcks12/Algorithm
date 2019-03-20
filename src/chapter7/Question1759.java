package chapter7;

import java.util.Arrays;
import java.util.Scanner;

public class Question1759 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int pwLength = sc.nextInt();
        int alphaLength = sc.nextInt();

        char[] alpha = new char[alphaLength];

        for(int i=0;i<alphaLength;i++){
            alpha[i] = sc.next().charAt(0);
        }
        Arrays.sort(alpha);

        go(pwLength, alpha, "", 0);

    }

    public static void go(int n, char[] alpha, String password, int i) {

        if(n==password.length()) {
            if(check(password)) {
                System.out.println(password);
            }
            return;

        }

        if(i >= alpha.length) {
            return;
        }

        go(n, alpha, password+alpha[i], i+1);
        go(n, alpha, password, i+1);

    }

    public static boolean check(String pw) {
        int ja=0;
        int mo=0;

        char[] pwArr = pw.toCharArray();


        for(int i=0;i<pw.length();i++){
            if(pwArr[i] == 'a' || pwArr[i] == 'e' || pwArr[i] == 'i' || pwArr[i] == 'o' || pwArr[i] == 'u') {
                mo++;
            } else{
                ja++;
            }
        }

        return (ja >= 2 && mo >= 1);
    }
}
