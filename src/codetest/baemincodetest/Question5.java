package codetest.baemincodetest;

public class Question5 {

    public static void main(String[] args){
        System.out.println(solution(34));
    }

    public static int solution(int number) {
        int answer = 0;
        for(int i=1;i<=number;i++){
            answer = answer+clap(i);
        }
        return answer;
    }

    public static int clap(int question){

        int len = 0;
        int questionTemp = question;
        while(questionTemp != 0){
            questionTemp = questionTemp / 10;
            len++;
        }
        int questionLength = len;
        int cnt = 0;
        int tmp;

        for(int i=questionLength-1;i>=0;i--){
            int pow = (int)Math.pow(10,i);
            tmp = question / pow;
            if(tmp == 3 || tmp == 6 || tmp == 9){
                cnt++;
            }
            question -= tmp * pow;
        }

        return cnt;
    }

    public static int findLength(int num){
        int len = 0;
        while(num != 0){
            num = num/10;
            len++;
        }
        return len;
    }
}
