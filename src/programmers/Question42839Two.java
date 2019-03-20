package programmers;
import java.util.*;

public class Question42839Two {
    public static void main(String[] args) {
        solution("011");
    }
    public static int solution(String numbers) {

        int answer = 0;
        int len = numbers.length();
        int limit = 1;

        for (int i = 0; i < len; i++) {
            limit = 10 * limit;
        }

        boolean[] prime = new boolean[limit];
        Set<Integer> set = new HashSet<>();
        int[] num = new int[len];

        //소수 구하기 완료
        for (int i = 2; i < Math.sqrt(limit); i++) {
            if (prime[i] == false) {
                for (int j = i * i; j < limit; j = j + i) {
                    prime[j] = true;
                }
            }
        }

        for(int i=2;i<prime.length;i++){
            prime[i] = !prime[i];
        }

        //받은 numbers를 정렬 후 순열은 전부 돌면서 Set에 넣음(중복 방지하여 모든 요소 넣는 과정)
        for(int i=0;i<len;i++){
            num[i] = (int)numbers.charAt(i) - '0';
        }
        Arrays.sort(num);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<len;i++){
            sb.append(num[i]);
            set.add(Integer.parseInt(sb.toString()));
        }

        while(nextPermutation(set, num) != "end");

        for(int setData : set){
            System.out.println(setData);

            if(prime[setData]){
                answer++;
            }
        }

        System.out.println(answer);


        return answer;
    }

    public static String nextPermutation(Set set, int[] num) {
        int i = num.length-1;
        int j = num.length-1;

        while(i>0 && num[i] <= num[i-1]) i--;

        if(i<=0) return "end";

        while(num[i-1] > num[j]) j--;
        int tmp;

        tmp = num[i-1];
        num[i-1] = num[j];
        num[j] = tmp;


        j = num.length-1;

        while(i<j){
            tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();

        for(int loop=0;loop<num.length;loop++){
            sb.append(num[loop]);
            set.add(Integer.parseInt(sb.toString())); // set에 모든 경우를 추가
        }


        return sb.toString();
    }



}
