package chapter4.practice;

import java.util.Scanner;

public class Question1107 {

    public static void main(String[] args){
        //수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.
        //
        //리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다. 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.
        //
        //수빈이가 지금 이동하려고 하는 채널은 N이다. 어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.
        //
        //수빈이가 지금 보고 있는 채널은 100번이다.

        int currentChannel = 100;

        Scanner sc = new Scanner(System.in);

        String goalChannel = sc.nextLine();


        int maxValueBtn = 9;
        int minValueBtn = 0;


        int goalArr[] = new int[goalChannel.length()];

        for(int i=0;i<goalChannel.length();i++){
            goalArr[i] = (int)goalChannel.charAt(i) - '0';
        }

        int brokenButtonCount = sc.nextInt();

        int brokenButtonArr[] = new int[brokenButtonCount];
        int firstBrokenNumber = -1;
        int firstBrokenIndex = -1;


        if(goalArr.length > Integer.parseInt(goalChannel) - currentChannel){  // 현재채널에서부터 +- 누르는게 더 빠를경우
            if(brokenButtonCount == 0) {
                System.out.println(goalChannel.length());
            } else{
                for(int i=0;i<brokenButtonCount;i++){
                    brokenButtonArr[i] = sc.nextInt();
                }
                System.out.println(Integer.parseInt(goalChannel)-currentChannel);
            }
//            System.out.println(Integer.parseInt(goalChannel) - currentChannel);
        } else{
            if(brokenButtonCount == 0) {
                System.out.println(goalChannel.length());
            } else if(brokenButtonCount == 10){
                for(int i=0;i<10;i++){
                    brokenButtonArr[i] = sc.nextInt();
                }
                System.out.println(Integer.parseInt(goalChannel)-currentChannel);
            } else {

                for(int i=0;i<brokenButtonCount;i++){
                    brokenButtonArr[i] = sc.nextInt();
                }

                for(int i=0;i<goalArr.length;i++){
                    if(contains(brokenButtonArr, goalArr[i])){
                        firstBrokenNumber = goalArr[i];
                        firstBrokenIndex = i;
                        break;
                    }
                }

                if(firstBrokenIndex == -1){
                    System.out.println(goalChannel.length());
                } else {

                    int buttonTarget = 0;

                    while(contains(brokenButtonArr, maxValueBtn)){
                        maxValueBtn--;
                    }

                    while(contains(brokenButtonArr, minValueBtn)){
                        minValueBtn++;
                    }


                    if(goalArr[firstBrokenIndex+1] >=0 && goalArr[firstBrokenIndex+1] <=4){

                        int indexMinNum = goalArr[firstBrokenIndex];

                        while(contains(brokenButtonArr, indexMinNum)){
                            if(indexMinNum>0){
                                indexMinNum--;
                            } else{
                                indexMinNum = minValueBtn;
                                break;
                            }
                        }

                        goalArr[firstBrokenIndex] = indexMinNum;

                        for(int i=firstBrokenIndex+1; i<goalArr.length ; i++){
                            goalArr[i] = maxValueBtn;
                        }

                        for( int temp=0; temp < goalArr.length; temp++){
                            buttonTarget*=10;
                            buttonTarget+=goalArr[temp];
                        }
                        System.out.println(goalArr.length + Integer.parseInt(goalChannel)-buttonTarget);

                    } else if(goalArr[firstBrokenIndex+1] >=5 && goalArr[firstBrokenIndex+1] <=9){
                        int indexMaxNum = goalArr[firstBrokenIndex];

                        while(contains(brokenButtonArr, indexMaxNum)){
                            if(indexMaxNum<9) {
                                indexMaxNum++;
                            } else{
                                indexMaxNum = maxValueBtn;
                                break;
                            }
                        }

                        for(int i=firstBrokenIndex+1; i<goalArr.length ; i++){
                            goalArr[i] = minValueBtn;
                        }

                        for(int i=0;i<goalArr.length;i++){
                            buttonTarget += goalArr[i] * 10^(goalArr.length-i-1);
                        }
                        System.out.println(goalArr.length + buttonTarget - Integer.parseInt(goalChannel));

                    }



                }







//                for(int i=firstBroken)



            }
        }

    }

    public static boolean contains(final int[] array, final int v) {

        for(int i=0;i<array.length;i++){
            if(array[i] == v) return true;
        }
        return false;
    }
}
