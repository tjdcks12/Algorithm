package baekjoon.practice;

import java.util.Scanner;

public class Question1107_2 {

    public static boolean[] broken = new boolean[10];


    public static int moveLength(int channel) {
        int length = 0;

        if (channel == 0) {
            return broken[0] ? 0 : 1;
        }
        while (channel > 0) {
            if (broken[channel % 10]) {
                return 0;
            }
            length++;
            channel = channel / 10;
        }
        return length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();
        int brokenCount = sc.nextInt();

        for (int i = 0; i < brokenCount; i++) {
            broken[sc.nextInt()] = true;
        }

        int answer = target - 100;
        if (answer < 0) answer = -answer;


        for (int i = 0; i <= 1000000; i++) {
            int c = i;
            int length = moveLength(i);

            if (length > 0) {
                int press = c - target;

                if (press < 0) {
                    press = -press;
                }
                if (answer > length + press) {
                    answer = length + press;
                }
            }
        }

        System.out.println(answer);

    }


}
