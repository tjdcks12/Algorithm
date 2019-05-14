package practice;

import java.util.Arrays;

public class Prime2 {

    public static boolean[] x = new boolean[101];

    public static void main(String[] args){

        Arrays.fill(x, true);

        x[0] = false;
        x[1] = false;

        for(int i=2;i<Math.sqrt(x.length);i++){
            for(int j=i*i;j<x.length;j+=i){
                x[j] = false;
            }
        }

        for(int i=0;i<x.length;i++){
            if(x[i]) System.out.println(i);
        }
    }
}
