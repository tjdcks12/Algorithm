//package samsung;
//
//import java.util.*;
//
//public class Question13460 {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        StringBuilder sb = new StringBuilder();
//        int targetIndex;
//        String start;
//        char[] board = new char[N * M];
//        Queue<String> queue = new LinkedList<>();
//        Map<String, Integer> map = new HashMap<String, Integer>();
//
//        int[] dx = {-1, 1, 0, 0};
//        int[] dy = {0, 0, -1, 1};
//
//        int index = 0;
//
//        for (int i = 0; i < N; i++) {
//            String tmp = sc.next();
//            for (int j = 0; j < tmp.length(); j++) {
//                board[index] = tmp.charAt(j);
//                if (board[index] == '0') {
//                    targetIndex = index;
//                }
//                index++;
//            }
//
//        }
//
//
//        for (int i = 0; i < board.length; i++) {
//            sb.append(board[i]);
//        }
//
//        start = sb.toString();
//
//        queue.add(start);
//        map.put(start, 0);
//
//        while (!queue.isEmpty()) {
//            String now = queue.poll();
//
//            move(M, now, map, "up");
//            move(M, now, map, "down");
//            move(M, now, map, "left");
//            move(M, now, map, "right");
//
//
//        }
//
//        checkMap(map);
//
//    }
//
//    public static void move(int M, String now, Map<String, Integer> map, String action) {
//
//        int redBallIndex=0;
//        int blueBallIndex=0;
//        int oldRI = now.indexOf('R');
//        int oldBI = now.indexOf('B');
//        boolean RH = false;
//        boolean BH = false;
//
//
//        switch (action) {
//            case "up":
//                while (now.charAt(redBallIndex) != '#') { // 벽마주치기전까지 위로 올림
//                    redBallIndex = redBallIndex - M;
//                    if (now.charAt(redBallIndex) == 'O') {
//                        RH = true;
//                        break;
//                    }
//                }
//                while (now.charAt(blueBallIndex) != '#') { // 벽마주치기전까지 위로 올림
//                    blueBallIndex = blueBallIndex - M;
//                    if (now.charAt(blueBallIndex) == 'O') {
//                        BH = true;
//                        break;
//                    }
//                }
//
//                if (now.charAt(redBallIndex) == '#') {
//                    redBallIndex = redBallIndex + M;
//                }
//                if (now.charAt(blueBallIndex) == '#') {
//                    blueBallIndex = blueBallIndex + M;
//                }
//
//            case "down":
//                while (now.charAt(redBallIndex) != '#') { // 벽마주치기전까지 위로 올림
//                    redBallIndex = redBallIndex + M;
//                    if (now.charAt(redBallIndex) == 'O') {
//                        RH = true;
//                        break;
//                    }
//                }
//                while (now.charAt(blueBallIndex) != '#') { // 벽마주치기전까지 위로 올림
//                    blueBallIndex = blueBallIndex + M;
//                    if (now.charAt(blueBallIndex) == 'O') {
//                        BH = true;
//                        break;
//                    }
//                }
//
//                if (now.charAt(redBallIndex) == '#') {
//                    redBallIndex = redBallIndex - M;
//                }
//                if (now.charAt(blueBallIndex) == '#') {
//                    blueBallIndex = blueBallIndex - M;
//                }
//
//            case "left":
//                while (now.charAt(redBallIndex) != '#') { // 벽마주치기전까지 위로 올림
//                    redBallIndex = redBallIndex - 1;
//                    if (now.charAt(redBallIndex) == 'O') {
//                        RH = true;
//                        break;
//                    }
//                }
//                while (now.charAt(blueBallIndex) != '#') { // 벽마주치기전까지 위로 올림
//                    blueBallIndex = blueBallIndex - 1;
//                    if (now.charAt(blueBallIndex) == 'O') {
//                        BH = true;
//                        break;
//                    }
//                }
//
//                if (now.charAt(redBallIndex) == '#') {
//                    redBallIndex = redBallIndex + 1;
//                }
//                if (now.charAt(blueBallIndex) == '#') {
//                    blueBallIndex = blueBallIndex + 1;
//                }
//
//            case "right":
//                while (now.charAt(redBallIndex) != '#') { // 벽마주치기전까지 위로 올림
//                    redBallIndex = redBallIndex + 1;
//                    if (now.charAt(redBallIndex) == 'O') {
//                        RH = true;
//                        break;
//                    }
//                }
//                while (now.charAt(blueBallIndex) != '#') { // 벽마주치기전까지 위로 올림
//                    blueBallIndex = blueBallIndex + 1;
//                    if (now.charAt(blueBallIndex) == 'O') {
//                        BH = true;
//                        break;
//                    }
//                }
//
//                if (now.charAt(redBallIndex) == '#') {
//                    redBallIndex = redBallIndex - 1;
//                }
//                if (now.charAt(blueBallIndex) == '#') {
//                    blueBallIndex = blueBallIndex - 1;
//                }
//
//        }
//
//
//        StringBuilder swap = new StringBuilder(now);
//        swap.setCharAt(oldRI, '.');
//        swap.setCharAt(oldBI, '.');
//
//        if (!RH) {
//            swap.setCharAt(redBallIndex, 'R');
//        }
//        if (!BH) {
//            swap.setCharAt(blueBallIndex, 'B');
//        }
//
//        String newStr = swap.toString();
//
//        map.put(newStr, map.get(now) + 1);
//
//    }
//
//    public static void boardUp(Map map, String board, int N, int M) {
//        String old = board;
//        int goal = board.indexOf('0');
//
////        dx[4]
//
//
//        if (!map.containsKey(board)) {
//            map.put(board, (int) map.get(old) + 1);
//        }
//
//    }
//
//    public static void checkMap(Map<String, Integer> map) {
//        for (String key : map.keySet()) {
//            if (key.indexOf('R') == -1 && key.indexOf('B') != -1) {
//                System.out.println(key);
//                System.out.println(map.get(key));
//            }
//        }
////        System.out.println(-1);
//    }
//}
