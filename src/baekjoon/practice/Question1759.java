package baekjoon.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Question1759 {

    static char[] alphabet;

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int L = sc.nextInt();
        int C = sc.nextInt();

        alphabet = new char[C];

        for(int i=0;i<C;i++){
            alphabet[i] = sc.next().charAt(0);
        }

        //정렬하고
        Arrays.sort(alphabet);

        recursive(L, alphabet, "", 0);


    }

    public static void recursive(int L, char[] alphabet, String pw, int idx){
        if(L == pw.length()){
            if(check(pw.toCharArray())) {
                System.out.println(pw);
            }
            return;
        }

        if(idx >= alphabet.length){
            return;
        }

        recursive(L, alphabet, pw + alphabet[idx], idx+1);
        recursive(L, alphabet, pw, idx+1);

    }

    public static boolean check(char[] arr){
        int mo = 0;
        int ja = 0;

        for(int i=0;i<arr.length;i++){
            if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
                mo++;
            } else{
                ja++;
            }
        }

        if(mo>=1 && ja>=2)
            return true;

        return false;
    }
}
