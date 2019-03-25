package datastructure;

public class hanoi {
    public static void main(String[] args){

        moveHanoi(4 , 'A', 'B', 'C');
    }


    public static void moveHanoi(int N, char from, char by, char to){

        if(N==1){
            System.out.println(from + "에서" + to +"로 갑니다.");
        } else {
            moveHanoi(N - 1, from, to, by);
            System.out.println(from + "에서" + to + "로 갑니다.");
            moveHanoi(N - 1, by, from, to);

        }

    }

}

