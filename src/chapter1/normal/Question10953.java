package chapter1.normal;

import java.util.Scanner;

public class Question10953 {
    public static void main(String[] args){
        int x;
        int y;
        Scanner sc = new Scanner(System.in);

        int loop = sc.nextInt();
        for(int i=0;i<loop;i++){
            String line = sc.next();
            x = Integer.parseInt(line.split(",")[0]);
            y = Integer.parseInt(line.split(",")[1]);
            System.out.println(x+y);
        }
    }
}
