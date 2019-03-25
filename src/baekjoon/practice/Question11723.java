package baekjoon.practice;

import java.util.Scanner;

public class Question11723 {


    public static void main(String args[]) {
        int loop;
        String command;

        Scanner sc = new Scanner(System.in);
        BitMask bitMask = new BitMask();


        loop = sc.nextInt();

        for(int i=0; i<loop; i++){
            command = sc.next();


            switch(command){
                case "add":
                    bitMask.add(sc.nextInt());
                    break;
                case "remove":
                    bitMask.remove(sc.nextInt());
                    break;
                case "check":
                    bitMask.check(sc.nextInt());
                    break;
                case "toggle":
                    bitMask.toggle(sc.nextInt());
                    break;
                case "all":
                    bitMask.all();
                    break;
                case "empty":
                    bitMask.empty();
                    break;
            }
        }

        bitMask.getResult();
    }
}

class BitMask{
    private int number = 0;
    private StringBuilder result = new StringBuilder();


    public void add(int x) {
        this.number = (this.number | 1 << x);
    }

    public void remove(int x) {
        this.number = (this.number & ~(1 << x));
    }

    public void check(int x) {
        if((this.number & (1 << x)) == 0){
            result.append("0\n");
        } else{
            result.append("1\n");

        }
    }

    public void toggle(int x) {
        this.number = this.number ^ (1<<x);
    }

    public void all() {
        this.number = (1<<21) - 1;
    }

    public void empty() {
        this.number = 0;
    }

    public void getResult() {
        System.out.println(this.result.toString());
    }
}