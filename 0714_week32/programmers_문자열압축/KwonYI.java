import java.util.*;

class Solution {
    
    Queue<Integer> q = new LinkedList<>();
    ArrayList<Integer> arr = new ArrayList<>();
    
    public int[] solution(int[] progresses, int[] speeds) {
        for(int i = 0; i < progresses.length; i++){
            int remain = 100 - progresses[i];
            int speed = speeds[i];
            int complete = remain / speed;
            
            if(remain % speed != 0){
                complete++;
            }
            
            if(q.isEmpty()){
                q.add(complete);
            }else{
                if(q.peek() >= complete){
                    q.add(complete);
                }else{
                    arr.add(q.size());
                    q.clear();
                }
            }
        }
        
        int[] answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}