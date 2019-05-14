package practice;

import java.util.Scanner;

public class QuestionExpert {

    static int T;
    static int N;
    static int[] A;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static class Atom {
        int x;
        int y;
        int movement;
        int power;

        public Atom(int x, int y, int movement, int power) {
            this.x = x;
            this.y = y;
            this.movement = movement;
            this.power = power;
        }
    }


    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        while (T >= 0) {
            N = sc.nextInt();
            A = new int[N];

            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int movement = sc.nextInt();
                int power = sc.nextInt();

                Atom atom = new Atom(x, y, movement, power);
            }


            T--;

        }
    }
}
