import java.util.*;

class Solution {
    
    int answer = Integer.MAX_VALUE;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        int len = words.length;
        visited = new boolean[len];
        
        find(begin, target, 0, len, words);
        
        if(answer == Integer.MAX_VALUE){
            answer = 0;
        }
        
        return answer;
    }
    
    public void find(String begin, String target, int cnt, int end, String[] words) {
        if(begin.equals(target)){
            answer = Math.min(answer, cnt);
            return;
        }
        
        if(cnt == end){
            return;
        }
        
        for(int i = 0; i < end; i++){
            if(visited[i]){
                continue;
            }
            
            if(canConvert(begin, words[i])){
                visited[i] = true;
                find(words[i], target, cnt + 1, end, words);
                visited[i] = false;
            }
        }
    }
    
    public boolean canConvert(String begin, String target) {
        int cnt = 0;
        
        for(int i = 0; i < begin.length(); i++){
            if(begin.charAt(i) != target.charAt(i)){
                cnt++;
            }
        }
        return cnt == 1;
    }
}