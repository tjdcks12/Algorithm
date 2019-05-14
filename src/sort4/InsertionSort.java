package sort4;

public class InsertionSort {
    static int[] arr = {3,1,2,4,6,7,9,8,5};

    public static void main(String[] args){
        sort(arr);

        for(int i=0;i<9;i++){
            System.out.println(arr[i]);
        }
    }

    public static void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int key = arr[i];
            int j = i-1;

            while(j>=0 && key < arr[j]){
                arr[j+1] = arr[j]; // 원래 i위치가 뒤덮여짐, 원래 i값은 key로 저장되있으므로
                j--;
            }
            arr[j+1] = key; //원래 i값을 j+1에 치환
        }
    }

}
