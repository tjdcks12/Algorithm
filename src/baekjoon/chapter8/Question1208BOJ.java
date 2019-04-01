package baekjoon.chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Question1208BOJ {


    static void makePre(int[] arr, int idx, int e, int sum, ArrayList<Integer> array) {
        if(idx>= e)//끝까지 다 돌았다면
        {
            array.add(sum);//추가
            return;
        }

        makePre(arr, idx+1, e, sum, array);//현재 인덱스를 포함할 때
        makePre(arr, idx+1, e, sum+arr[idx], array);//현재 인덱스를 포함하지 않을 때
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(stringTokenizer.nextToken());
        int S=Integer.parseInt(stringTokenizer.nextToken());

        int[] arr=new int[N];

        stringTokenizer=new StringTokenizer(br.readLine());
        int k=0;
        while(stringTokenizer.hasMoreTokens())
            arr[k++]=Integer.parseInt(stringTokenizer.nextToken());

        ArrayList<Integer> first_arr=new ArrayList<>();
        ArrayList<Integer> second_arr=new ArrayList<>();

        makePre(arr,0,N/2, 0, first_arr);
        makePre(arr,N/2, arr.length, 0, second_arr);

        Collections.sort(first_arr);
        Collections.sort(second_arr);

        int left=0;
        int right=second_arr.size()-1; // right는 두번째 리스트의 마지막

        int ans=0;

        while(left < first_arr.size() && right >=0) {
            int leftValue=first_arr.get(left);
            int rightValue=second_arr.get(right);

            if(leftValue+rightValue == S) {//S와 일치하면,  각 분할 집합에서 해당 합을 지니는 원소의 개수를 셈
                int leftCount=0;
                while(  left<first_arr.size() && first_arr.get(left)== leftValue) {
                    leftCount++;
                    left++;
                }

                int rightCount=0;
                while( right >=0 && second_arr.get(right)== rightValue) {
                    rightCount++;
                    right--;
                }

                ans+=leftCount*rightCount;
            }

            if(leftValue+rightValue > S)
                right--;
            if(leftValue+rightValue < S)
                left++;

        }

        if(S==0) {
            ans-= 1;
        }

        System.out.println(ans);

    }
}
