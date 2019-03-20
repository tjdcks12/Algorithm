package linecodetest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cony = sc.nextInt();
        int brown = sc.nextInt();
        boolean catched = false;

        Queue<Integer> queue = new LinkedList<>();

        int speed = -1;
        queue.add(brown);

        while(true) {
            speed += 1;
            cony += speed;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.peek();
                if (cony == now) {
                    catched = true;
                    break;
                }

                queue.poll();
                for (int j = 0; j < 3; j++) {
                    int next = 0;
                    if (j == 0) {
                        next = now + 1;
                    } else if (j == 1) {
                        next = now - 1;
                    } else if (j == 2){
                        next = now * 2;
                    }
                    if (next >= 0 && next < 200000) {
                        queue.add(next);
                    }
                }
            }
            if (catched) break;
            if (cony >= 200000) break;
        }

        if(catched){
            System.out.println(speed);
        } else {
            System.out.println(-1);
        }


    }
}


