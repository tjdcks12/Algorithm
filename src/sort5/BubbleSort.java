package sort5;

public class BubbleSort {
    static int[] arr = {3,1,2,4,6,7,9,8,5};

    public static void main(String[] args){
        sort(arr);
        for(int i=0;i<9;i++){
            System.out.println(arr[i]);
        }
    }
    public static void sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}
