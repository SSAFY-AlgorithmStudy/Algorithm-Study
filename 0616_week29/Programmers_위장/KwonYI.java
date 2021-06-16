import java.util.*;

class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    
    public int solution(String[][] clothes) {
        for(String[] wear : clothes){
            map.put(wear[1], map.getOrDefault(wear[1], 0) + 1);
        }
        
        int answer = 1;
        for(int key : map.values()){
            answer *= (key + 1);
        }
        
        return answer - 1;
    }
}