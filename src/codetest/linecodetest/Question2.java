package codetest.linecodetest;

import java.util.*;

public class Question2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.next());
        StringBuilder sb2 = new StringBuilder();

        int count = initCount(sb);

        String[] arr = new String[count];
        int[] countArr = new int[count];
        int idx = 0;
        int countIndex = 0;


        for(int i = 0; i < sb.length();){
            char x = sb.charAt(i);
            if(Character.isDigit(x))
            {
                countArr[countIndex] = Character.getNumericValue(x);
                countIndex++;
                i++;

            } else{
                if((i + 1) <= sb.length() - 1 && !Character.isLowerCase(sb.charAt(i + 1))) {
                    i++;
                    arr[idx] = Character.toString(x);
                    idx++;
                }
                else{
                    int j = i + 1;
                    while(j <= sb.length() - 1 && Character.isLowerCase(sb.charAt(j))){
                        j++;
                    }
                    arr[idx] = sb.substring(i, j);
                    idx++;
                    i = j;
                }
            }
        }


        for(int i = 0 ; i < arr.length; i++){

            if(countArr[i] == 0){
                System.out.println("error");
                break;
            } else if(countArr[i] == 1){
                sb2.append(arr[i]);
            } else{
                sb2.append(arr[i] + countArr[i]);
            }

            if(i == arr.length - 1){
                System.out.println(sb2);
            }
        }
    }

    public static int initCount(StringBuilder sb){
        int count = 0;
        for(int i = 0; i < sb.length();){
            char x = sb.charAt(i);
            if(Character.isDigit(x)) break;

            else{
                if((i + 1) <= sb.length() - 1 && !Character.isLowerCase(sb.charAt(i + 1))) {
                    count++;
                    i++;
                }else{
                    int j = i + 1;
                    while(j <= sb.length() - 1 && Character.isLowerCase(sb.charAt(j))){
                        j++;
                    }
                    count++;
                    i = i + (j - i);
                }
            }
        }
        return count;
    }




}
