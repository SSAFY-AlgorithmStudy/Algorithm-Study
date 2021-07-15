import java.util.*;

class Solution {
    
    HashMap<String, String> names = new HashMap<>();
    ArrayList<String> orders = new ArrayList<>();
    
    public String[] solution(String[] record) {
        for(String r : record){
            String[] rArr = r.split(" ");
            
            if("Enter".equals(rArr[0])){
                names.put(rArr[1], rArr[2]);
                orders.add(r);
            }else if("Leave".equals(rArr[0])){
                orders.add(r);
            }else{
                names.put(rArr[1], rArr[2]);
            }
        }
        
        String[] answer = new String[orders.size()];
        for(int index = 0 ; index < orders.size(); index++){
            String order = orders.get(index);
            String[] orderArr = order.split(" ");
            
            if("Enter".equals(orderArr[0])){
                answer[index] = names.get(orderArr[1]) + "님이 들어왔습니다.";
            }else {
                answer[index] = names.get(orderArr[1]) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}