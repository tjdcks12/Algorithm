package chapter1.normal;

import java.util.Scanner;

public class Question11021 {
    public static void main(String[] args){
        int x;
        int y;
        Scanner sc = new Scanner(System.in);

        int loop = sc.nextInt();
        for(int i=0;i<loop;i++){
          x = sc.nextInt();
          y = sc.nextInt();

          System.out.println(new StringBuilder("Case #").append(i+1).append(": ").append(x+y).toString());
        }
    }
}
