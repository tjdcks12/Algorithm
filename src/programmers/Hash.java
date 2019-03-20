package programmers;
import java.util.*;


public class Hash {

    class Solution {
        public String solution(String[] participant, String[] completion) {
            Map<String,Integer> map = new HashMap<>();
            String answer = "";

            for(int i=0;i<participant.length;i++){
                if(map.containsKey(participant[i])){
                    map.put(participant[i], map.get(participant[i])+1);
                } else{
                    map.put(participant[i], 1);
                }
            }

            for(int i=0;i<completion.length;i++){
                map.put(completion[i], map.get(completion[i])-1);
            }

            for(String key : map.keySet()) {
                if(map.get(key) == 1){
                    answer = key;
                }
            }



            return answer;
        }
    }
}
