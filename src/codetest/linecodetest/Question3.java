package codetest.linecodetest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Question3 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int tableOneRow = sc.nextInt();
        Set<String> headerSet = new HashSet<>();

        String firstHeader = sc.nextLine();

        String[] arr = firstHeader.split(" ");

        String[] tableOneHeader = new String[tableOneRow];


        for(int i=0;i<tableOneRow;i++){
            if(i==0){
                String headers = sc.nextLine();
                System.out.println(headers);
                tableOneHeader = headers.split(" ");
            } else{
                String rowStr = sc.nextLine();
                rowStr.split(" ");
            }
        }

//        for(int i=0;i<tableOneHeader.length;i++){
//            System.out.println(tableOneHeader[i]);
//        }

        int tableTwoRow = sc.nextInt();

        String[] tableTwoHeader = new String[tableTwoRow];

        for(int i=0;i<tableTwoRow;i++){
            if(i==0){
                String headers = sc.nextLine();
                tableTwoHeader = headers.split(" ");
            } else{
                String rowStr = sc.nextLine();
                rowStr.split(" ");
            }
        }


        for(int i=0;i<tableOneHeader.length;i++){
            headerSet.add(tableOneHeader[i]);
        }
        for(int i=0;i<tableTwoHeader.length;i++){
            headerSet.add(tableTwoHeader[i]);
        }

        String[] resultHeader = new String[headerSet.size()];

        resultHeader[0] = "id";

        int idx=1;
        for(String str : headerSet){
            if(!str.equals("id") && idx < resultHeader.length){
                resultHeader[idx] = str;
                idx++;
            }
        }

        for(int i=0;i<resultHeader.length;i++){
            if(i==0){
                resultHeader[0] = "id";
            } else{

            }
        }

        for(int i=0;i<resultHeader.length;i++) {
            System.out.println(resultHeader[i]);
        }

    }


}