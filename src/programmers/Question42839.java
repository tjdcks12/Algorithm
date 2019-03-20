package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question42839 {

    public static void main(String[] args) {
        solution("17");
    }

    public static int solution(String numbers) {
        int answer = 0;

        int len = numbers.length();
        Set<String> set = new HashSet<>();

        List<Integer> primeList = new ArrayList<>();
        int arrSize = 1;


        for (int i = 0; i < len; i++) {
            arrSize = arrSize * 10;
        }
        boolean[] prime = new boolean[arrSize];

        for (int i = 2; i < Math.sqrt(arrSize); i++) {
            if (prime[i] == false) {
                for (int j = i * i; j < arrSize; j = j + i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 2; i < prime.length; i++) {
            prime[i] = !prime[i];
            if (prime[i] == true) {
                primeList.add(i);

            }
        }


        int[] num = {1, 2, 3};


        do{
            StringBuilder sb= new StringBuilder();
            for(int i=0;i<num.length;i++){
                sb.append(num[i]);
            }
            String numStr = sb.toString();
            System.out.println(numStr);
            set.add(numStr);
        } while(nextPermutation(num) != "end");

        for(String setData : set){
            for(int i=1;i<=numbers.length();i++){
                String sub = setData.substring(0, i);
                set.add(sub);
            }
        }

        for(String setData : set){
            int setNum = Integer.parseInt(setData);

            if(prime[setNum]) {
                System.out.println(setNum);
                answer++;
            }
        }


        return answer;
    }


    public static String nextPermutation(int[] num) {

        int i = num.length - 1;
        int j = num.length - 1;

        while (i > 0 && num[i] < num[i - 1]) i--;

        if (i <= 0) return "end";

        while (num[i - 1] >= num[j]) j--;

        int tmp;
        tmp = num[i - 1];
        num[i - 1] = num[j];
        num[j] = tmp;

        j = num.length - 1;

        while (i <= j) {
            tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;

            i++;
            j--;
        }

        StringBuilder sb = new StringBuilder();

        for (int z = 0; z < num.length; z++) {
            sb.append(num[z]);
        }
        return sb.toString();
    }


}
