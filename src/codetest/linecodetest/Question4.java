package codetest.linecodetest;

import java.util.Scanner;
import java.util.Stack;

public class Question4 { //stack

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int max = 0;
        int point = 0;
        int answer = 0;


        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < x; i++) {


            int num = sc.nextInt();
            if(i==0) point = num;

            stack.push(num);

            if (point <= num) {
                point = num;
                while (!stack.isEmpty()) {
                    stack.pop();
                    answer++;
                }
                if(max < answer) max = answer;
                answer = 0;
                stack.push(num);
            }

        }

        System.out.println(max-1);
    }
}

