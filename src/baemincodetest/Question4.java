package baemincodetest;

public class Question4 {

    public static void main(String[] args){
        int[] pobi = {401, 402};
        int[] crong = {133, 134};
        solution(pobi, crong);
    }
    public static int solution(int[] pobi, int[] crong) {


        int pobiMax = findMax(pobi);
        int crongMax = findMax(crong);


        if((isValid(pobi) && isValid(crong)) != true){
            System.out.println(-1);
            return -1;
        } else{
            if(pobiMax>crongMax){
                System.out.println(1);
                return 1;
            } else if(pobiMax<crongMax){
                System.out.println(2);
                return 2;
            } else{
                System.out.println(0);
                return 0;
            }
        }
    }


    public static boolean isValid(int[] arr){
        return ((arr[1] == arr[0]+1) && (arr[0] % 2 == 1));
    }

    public static int findMax(int[] arr){

        int left = arr[0];
        int right = arr[1];
        int leftResult = 0;
        int leftResult2 = 1;
        int rightResult = 0;
        int rightResult2 = 1;

        int[] leftArr = getArr(left);
        int[] rightArr = getArr(right);

        for(int i=0;i<leftArr.length;i++){
            leftResult += leftArr[i];
            leftResult2 *= leftArr[i];
        }

        for(int i=0;i<rightArr.length;i++){
            rightResult += rightArr[i];
            rightResult2 *= rightArr[i];
        }

        int max = Math.max(leftResult, leftResult2);
        max = Math.max(max, rightResult);
        max = Math.max(max, rightResult2);

        return max;
    }

    public static int findLength(int num){
        int len = 0;
        while(num != 0){
            num = num/10;
            len++;
        }
        return len;
    }

    public static int[] getArr(int value){
        int valueLength = findLength(value);
        int[] arr = new int[valueLength];

        for(int i=arr.length-1;i>=0;i--){
            int pow = (int)Math.pow(10,i);
            arr[i] = value / pow;
            value -= arr[i] * pow;
        }

        return arr;
    }

}
