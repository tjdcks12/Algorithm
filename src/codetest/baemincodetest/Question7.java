package codetest.baemincodetest;

import java.util.Scanner;

public class Question7 {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(solution(scan.next()));
    }

    public static String solution(String cryptogram) {
        String answer = cryptogram;
        int duplicateIdx = findDuplicateIdx(answer);
        while (duplicateIdx != answer.length() - 1) {
            answer = decrypt(answer, duplicateIdx);
            if (answer.length() == 0) break;
            duplicateIdx = findDuplicateIdx(answer);
        }

        return answer;
    }

    public static String decrypt(String str, int duplicateIdx) {
        StringBuilder sb = new StringBuilder(str);
        while (duplicateIdx < sb.length()) {
            char a = sb.charAt(duplicateIdx);
            int nextIdx = duplicateIdx + 1;

            if (nextIdx < sb.length() && a == sb.charAt(nextIdx)) {
                while (nextIdx < sb.length() && a == sb.charAt(nextIdx)) nextIdx++;
                sb.replace(duplicateIdx, nextIdx, "");
                continue;
            }
            duplicateIdx++;
        }

        return sb.toString();
    }

    public static int findDuplicateIdx(String str) {
        int idx = 0;
        while (idx < str.length() - 1) {
            if (str.charAt(idx) == str.charAt(idx + 1)) return idx;
            idx++;
        }
        return idx;
    }

}
