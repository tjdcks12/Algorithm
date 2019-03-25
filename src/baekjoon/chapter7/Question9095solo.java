package baekjoon.chapter7;

public class Question9095solo {

    public static void main(String[] args){
        System.out.println(go(0,10));
    }

    public static int go(int sum, int goal){
        int now = 0;
        if(sum > goal) return 0;
        if(sum == goal) return 1;

        for(int i=1;i<=3;i++){
            now += go(sum+i, goal);
        }
        return now;
    }
}
