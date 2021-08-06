import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> names = new HashMap();
        for(int i=0;i<participant.length;i++){
            if(names.containsKey(participant[i])){
               names.put(participant[i],names.get(participant[i])+1);
            }else{
                names.put(participant[i],1);
            }
        }
       for(int i=0;i<completion.length;i++){
            if(names.containsKey(completion[i])){
               names.put(completion[i],names.get(completion[i])-1);
            }
        }
        for( String str: names.keySet()){ 
        if(names.get(str)==1){
            answer = str;
            break;
        }
        }
        return answer;
    }
}
