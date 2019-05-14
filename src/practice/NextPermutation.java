package practice;

public class NextPermutation {

    static int loop = 0;
    public static void main(String[] args){
        int[] x = {4, 1, 5, 2, 3};

        do{
            for(int i=0;i<x.length;i++){
                System.out.print(x[i]);
            }
            System.out.println();
        }
        while(nextPermutation(x));
    }

    public static boolean nextPermutation(int[] arr){


        loop++;
        int i = arr.length - 1;
        int j = arr.length - 1;
        int temp;

        while(i>0 && arr[i-1] >= arr[i])  i--;

        if(i <= 0) return false;

        while(arr[j] <= arr[i-1]) {
            j--;
            System.out.println("여기왔어");
        }

        temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

        j = arr.length-1;
        while(i<j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
        return true;
    }

}
