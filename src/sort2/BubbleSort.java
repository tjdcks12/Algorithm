package sort2;

public class BubbleSort {
    public static void main(String[] args){
        int[] arr = {3,1,2,6,9,5,7,8,4};

        sort(arr);

        for(int i=0;i<9;i++){
            System.out.println(arr[i]);
        }
    }

    public static void sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}
