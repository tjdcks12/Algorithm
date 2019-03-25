package baekjoon.chapter6;

import java.util.*;

public class Question1963 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        //소수 판별 배열
        boolean prime[] = new boolean[10000];

        //소수 배열 초기화
        for(int i=2;i<Math.sqrt(10000);i++){
            if(prime[i] == false) {
                for(int j=i*i;j<10000;j=j+i){
                    prime[j] = true;
                }
            }
        }

        // true이면 소수, false면 소수아님
        for(int i=0;i<prime.length;i++){
            prime[i] = !prime[i];
        }


        for(int k=0;k<testCase;k++){
            int num = sc.nextInt();
            int target = sc.nextInt();
            int[] visited = new int[10000];
            //방문 횟수 체크 배열
            Arrays.fill(visited, -1);

            Queue<Integer> queue = new LinkedList<Integer>();
            queue.offer(num);
            visited[num] = 0;

            while(!queue.isEmpty()){
                int number = queue.poll();
                if(number == target){ // 구하려는 값과 일치할때 출력
                    System.out.println(visited[number]);
                }
                for (int i = 0; i < 4; i++) {
                    int[] temp = toArr(number);
                    for (int j = 0; j < 10; j++) {
                        if (i != 0 || j != 0) {
                            if (temp[i] != j) {
                                int result = toInt(temp, i, j);
                                if (visited[result] == -1 && prime[result]) {
                                    visited[result] = visited[number] + 1;
                                    queue.offer(result);
                                }
                            }
                        }
                    }
                }

            }



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

    public static int toInt(int[] arr, int index, int value) {
        arr[index] = value;
        return (arr[0] * 1000) + (arr[1] * 100) + (arr[2] * 10) + arr[3];
    }

    public static boolean isPrime(boolean[] prime, int num){
        return prime[num];
    }



}
