package baekjoon.practice;

public class Hackday3 {

    public static int solution(long[] T) {
        int ans = 0;
        long winterMax = T[0];
        long temp = T[0];
        int tempAns = 0;

        for(int i=1;i<T.length;i++){
            if(T[i] > winterMax) {
                temp = T[i];
                tempAns = i;

            } else{
                if(winterMax != temp){
                    winterMax = temp;
                    ans = ++tempAns;
                } else{
                    ans++;
                }
            }
        }

        System.out.println(ans+1);

        return ans+1;
    }

    public static void main(String[] args){
        long[] x = {0,0,0,0,0,0};
        solution(x);
    }
}
