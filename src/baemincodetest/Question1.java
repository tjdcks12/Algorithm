package baemincodetest;

public class Question1 {
    public static void main(String[] args){
        solution(987123);
    }

    public static int[] solution(int money) {
        int[] answer = new int[9];
        int idx = 0;

        int tmp = 50000;

        while(money>10){
            if(money >= tmp) {
                int share = money/tmp;
                money = money%tmp;
                answer[idx] = share;
            }
            if(idx%2==0) {
                tmp = tmp/5;
            } else {
                tmp = tmp/2;
            }
            idx++;
        }
        answer[8] = money;

        for(int i=0;i<9;i++){
            System.out.println(answer[i]);
        }
        return answer;
    }
}
