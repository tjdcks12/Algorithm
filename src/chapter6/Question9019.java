package chapter6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question9019 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int k=0;k<testCase;k++){
            int number = sc.nextInt();
            int target = sc.nextInt();
            String[] visited = new String[10001];
            boolean[] checked = new boolean[10001];

            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(number);

            for(int i=0;i<visited.length;i++){
                visited[i] = "";
            }

            checked[number] = true;

            while(!queue.isEmpty()){

                int[] dslr = new int[4];
                int num = queue.poll();

                for(int i=0;i<dslr.length;i++){
                    if(i==0){
                        int result = (num * 2) % 10000;
                        if(checked[result] == false){
                            checked[result] = true;
                            queue.offer(result);
                            visited[result] = visited[num] + "D";
                        }
                    }

                    if(i==1){
                        int result = num;
                        if(result == 0) result = 9999;
                        else {
                            result = num-1;
                        }
                        if(checked[result] == false){
                            checked[result] = true;
                            queue.offer(result);
                            visited[result] = visited[num] + "S";
//                            System.out.println(visited[result]);
                        }
                    }

                    if(i==2){
                        int result = num;
                        int[] numArr = toArr(result);
                        int temp;

                        temp = numArr[0];
                        numArr[0] = numArr[1];
                        numArr[1] = numArr[2];
                        numArr[2] = numArr[3];
                        numArr[3] = temp;

                        result = toInt(numArr);

                        if(checked[result] == false){
                            checked[result] = true;
                            queue.offer(result);
                            visited[result] = visited[num] + "L";
//                            System.out.println(visited[result]);

                        }
                    }

                    if(i==3){
                        int result = num;
                        int[] numArr = toArr(result);
                        int temp;

                        temp = numArr[3];
                        numArr[3] = numArr[2];
                        numArr[2] = numArr[1];
                        numArr[1] = numArr[0];
                        numArr[0] = temp;

                        result = toInt(numArr);

                        if(checked[result] == false){
                            checked[result] = true;
                            queue.offer(result);
                            visited[result] = visited[num] + "R";
//                            System.out.println(visited[result]);
                        }
                    }
                }


            }
            System.out.println(visited[target]);


        }

    }

    public static int[] toArr(int num) {
        int[] numArr = new int[4];
        numArr[0] = num / 1000;
        numArr[1] = (num/100) % 10;
        numArr[2] = (num/10) % 10;
        numArr[3] = num % 10;

        return numArr;
    }

    public static int toInt(int[] arr) {
        return (arr[0] * 1000) + (arr[1] * 100) + (arr[2] * 10) + arr[3];
    }
}
