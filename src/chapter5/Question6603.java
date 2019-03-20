package chapter5;

import java.util.Scanner;

public class Question6603 {

    public static boolean next_permutation(int[] arr){
        int s=0; int e=arr.length;
        //arr[i-1] < arr[i]를 만족하는 가장 큰 i
        int i=e-1;
        for(; i>s; i--){
            if(arr[i-1] >=arr[i])
                continue;
            else
                break;
        }
        if(i==0) return false;

        //i<=j를 만족하고, A[j]>A[i-1]를 만족하는 가장 큰 j
        int j=e-1;
        for(; j>=i; j--){
            if(arr[j]<=arr[i-1])
                continue;
            else
                break;
        }


        //A[i-1], A[j] swap
        int tmp=arr[i-1];
        arr[i-1]=arr[j];
        arr[j]=tmp;
        //1234567
        //i부터 끝까지 뒤집음
        j=e-1;
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++; j--;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        boolean flag=false;
        while(true) {
            int k=scan.nextInt();
            if(k==0) return;
            int[] arr=new int[k];

            for(int i=0; i<k; i++)
                arr[i]=scan.nextInt();
            if(flag)
                System.out.println();
            int[] roto=new int[k];
            for(int i=0; i<k; i++) {
                if(i<6)
                    roto[i]=0;
                else
                    roto[i]=1;
            }

            do {
                for(int i=0; i<k; i++) {
                    if(roto[i]==0)
                        System.out.print(arr[i]+" ");
                }
                System.out.println();
                flag=true;
            }while(next_permutation(roto));


        }
    }
}
