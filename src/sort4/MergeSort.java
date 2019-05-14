package sort4;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3,1,2,6,9,5,7,8,4};

        mergeSort(arr, 0, arr.length-1);

        for(int i=0;i<9;i++){
            System.out.println(arr[i]);
        }
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = (left+right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int leftLeastIdx = left;
        int rightLeastIdx = mid+1;
        int sortedArrIdx = left;

        int[] sortedArr = new int[arr.length];

        while(leftLeastIdx <= mid && rightLeastIdx <= right) {
            if(arr[leftLeastIdx] < arr[rightLeastIdx]) {
                sortedArr[sortedArrIdx++] = arr[leftLeastIdx++];
            } else {
                sortedArr[sortedArrIdx++] = arr[rightLeastIdx++];
            }
        }

        while(leftLeastIdx <= mid) sortedArr[sortedArrIdx++] = arr[leftLeastIdx++];
        while(rightLeastIdx <= right) sortedArr[sortedArrIdx++] = arr[rightLeastIdx++];

        for(int i=left;i<sortedArrIdx;i++){
            arr[i] = sortedArr[i];
        }


    }

}
