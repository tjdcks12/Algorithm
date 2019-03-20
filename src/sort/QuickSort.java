package sort;

public class QuickSort {


    public static void main(String[] args) {

        int[] arr = {3,1,2,6,9,5,7,8,4};


        quickSort(arr, 0, arr.length - 1);
        for(int i=0;i<9;i++){
            System.out.println(arr[i]);
        }
    }

    public static void quickSort(int[] data, int l, int r) {
        int left = l;
        int right = r;
        int pivot = data[(l + r) / 2];

        do {
            while (data[left] < pivot) left++;
            while (data[right] > pivot) right--;
            if (left <= right) {
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        } while (left <= right);

        if (l < right) quickSort(data, l, right);
        if (r > left) quickSort(data, left, r);
    }

}
