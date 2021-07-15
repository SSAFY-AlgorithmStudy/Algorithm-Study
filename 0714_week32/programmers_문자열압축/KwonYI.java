import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length() / 2; i++){
            int index = 0;
            Queue<String> q = new LinkedList<>();
            
            while(index < s.length()){
                q.add(s.substring(index, Math.min(s.length(), index + i)));
                index += i;
            }
            
            int zipLen = 0;
            while(!q.isEmpty()){
                String cur = q.poll();
                zipLen += cur.length();
                
                int cnt = 1;
                while(!q.isEmpty() && cur.equals(q.peek())){
                    cnt++;
                    q.poll();
                }
                
                if(cnt != 1){
                    zipLen += Integer.toString(cnt).length();
                }
            }
            
            answer = Math.min(answer, zipLen);
        }
        
        return answer;
    }
}