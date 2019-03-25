package baekjoon.chapter1.practice;

import java.util.Scanner;

public class Question1924 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = 1;
        int x = sc.nextInt();
        int y = sc.nextInt();
        // 1월 1일 : 월요일, 8일도 월요일
        int day = 0;

        while (i < x) {
            i++;

            if (i == 2 || i == 4 || i == 6 || i == 8 || i == 9 || i == 11)
                day = day + 31;
            if (i == 5 || i == 7 || i == 10 || i == 12)
                day = day + 30;
            if (i == 3)
                day = day + 28;

            day = day;
        }
        day = day+y;


        switch (day % 7) {
            case 0:
                System.out.println("SUN");
                break;
            case 1:
                System.out.println("MON");
                break;
            case 2:
                System.out.println("TUE");
                break;
            case 3:
                System.out.println("WED");
                break;
            case 4:
                System.out.println("THU");
                break;
            case 5:
                System.out.println("FRI");
                break;
            case 6:
                System.out.println("SAT");
                break;
        }
    }
}
