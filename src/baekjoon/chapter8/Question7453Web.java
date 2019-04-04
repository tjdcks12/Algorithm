package baekjoon.chapter8;

import java.util.Arrays;
import java.util.Scanner;

public class Question7453Web {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] get = new int[4][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                get[j][i] = sc.nextInt();
            }
        }

        int[] plus1 = new int[n * n];
        int[] plus2 = new int[n * n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                plus1[count] = get[0][i] + get[1][j];
                plus2[count++] = get[2][i] + get[3][j];
            }
        }
        Arrays.sort(plus1);
        Arrays.sort(plus2);

        long zero = 0;
        int min = 0, max = n * n - 1;
        long count1, count2;
        int temp1, temp2;

        while (min < n * n && max >= 0) {
            if (plus1[min] + plus2[max] < 0) min++;
            else if (plus1[min] + plus2[max] == 0) {
                count1 = 0;
                count2 = 0;
                temp1 = plus1[min];
                temp2 = plus2[max];
                for (; min < n * n; min++) {
                    if (plus1[min] == temp1) count1++;
                    else break;
                }
                for (; max >= 0; max--) {
                    if (plus2[max] == temp2) count2++;
                    else break;
                }
                zero += count1 * count2;
            } else max--;
        }
        System.out.print(zero);

    }
}

