package sort;

public class BubbleSort {

    public static void main(String[] args){
        int[] arr = {3,1,2,6,9,5,7,8,4};


        for(int i=0;i<arr.length-1;i++){
            for(int j=1;j<arr.length-i;j++){
                if(arr[j-1] > arr[j]){
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        for(int i=0;i<9;i++){
            System.out.println(arr[i]);
        }
    }

}
