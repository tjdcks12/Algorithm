package codetest.baemincodetest;


public class Question3 {


    public static void main(String[] args) {

        System.out.println(solution("I love you"));

    }

    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (!Character.isAlphabetic(letter)) {
                sb.append(letter);
            } else if(Character.isLowerCase(letter)) { //ASCII 값을 가우스
                sb.append((char) (97+122 - letter));
            } else if(Character.isUpperCase(letter)) {
                sb.append((char) (65+90 - letter));
            }
        }
        return sb.toString();
    }
}
