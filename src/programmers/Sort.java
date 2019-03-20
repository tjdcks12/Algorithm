package programmers;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args){
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        new Solution().solution(array, commands);
    }


}

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int loop=0;loop<commands.length;loop++){

            int first = commands[loop][0];
            int last = commands[loop][1];
            int index = commands[loop][2];

            int len = last-first+1;
            int[] cutArr = new int[len];

            for(int i=0;i<len;i++){
                cutArr[i] = array[first+i-1];
            }
            Arrays.sort(cutArr);
            answer[loop] = cutArr[index-1];


        }
        return answer;

    }
}