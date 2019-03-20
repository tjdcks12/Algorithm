package sort;

public class SelectionSort {

    public static void main(String[] args){
        int[] arr = {3,1,2,6,9,5,7,8,4};


        for(int i=0;i<arr.length-1;i++){
            int tmp = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[tmp] > arr[j]) {
                    tmp = j;
                }
            }
            int tmpv = arr[tmp];
            arr[tmp] = arr[i];
            arr[i] = tmpv;
        }

        for(int i=0;i<9;i++){
            System.out.println(arr[i]);
        }
    }
}
