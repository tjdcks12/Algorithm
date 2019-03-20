package baemincodetest;

import java.util.*;


public class Question6 {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] stringArr = {
                "woni request 09:00:00",
                "brown request 09:23:11",
                "brown leave 09:23:44",
                "jason request 09:33:51",
                "jun request 09:33:56",
                "cu request 09:34:02"
        };

        solution(10, stringArr);
    }

    public static String[] solution(int totalTicket, String[] logs) {

        Stack<String> stack = new Stack();
        int i = 0;

        String id;
        String action;
        String curTime;
        String oldTime = "08:59:00";;

        while (i < logs.length) {
            StringTokenizer st = new StringTokenizer(logs[i]);
            while (st.hasMoreTokens()) {
                id = st.nextToken();
                if (stack.contains(id)) {
                    stack.remove(id);
                    break;
                }
                action = st.nextToken();
                curTime = st.nextToken();
                if (overMinute(oldTime, curTime) == false) break;

                stack.push(id);
                oldTime = curTime;
            }
            i++;
        }

        Object[] answerArr = stack.toArray();
        Arrays.sort(answerArr);

        String[] answer = new String[answerArr.length];

        int idx = 0;
        while(idx < totalTicket && !stack.isEmpty()){
            answer[idx] = stack.pop();
            idx++;
        }
        return answer;
    }

    public static boolean overMinute(String oldTime, String curTime) {
        int oldMin = Integer.parseInt(oldTime.substring(3, 5));
        int curMin = Integer.parseInt(curTime.substring(3, 5));

        int diff = curMin - oldMin;
        if (diff == 0) return false;
        else if (diff == 1) {
            int oldSecond = Integer.parseInt(oldTime.substring(6, 8));
            int curSecond = Integer.parseInt(curTime.substring(6, 8));
            if (curSecond - oldSecond >= 0) return true;
            else return false;
        }

        return true;
    }

}
