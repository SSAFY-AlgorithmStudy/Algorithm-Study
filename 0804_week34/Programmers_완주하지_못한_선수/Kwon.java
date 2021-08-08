import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> players = new HashMap<>();
        String answer = null;
        
        for(String p : participant) {
            players.put(p, players.getOrDefault(p, 0) + 1);
        }
        
        for(String c : completion){
            players.put(c, players.get(c) - 1);
        }
        
        for(String key : players.keySet()){
            if(players.get(key) != 0){
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}