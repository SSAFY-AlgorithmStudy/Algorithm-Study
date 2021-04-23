import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        HashSet<String> hs = new HashSet<>();
        for(String str: phone_book){
            for(int i=0;i<=str.length();i++){
                String splitStr = str.substring(0,i);
               if(hs.contains(splitStr)){
                   return false;
               }
            }
            if(!hs.contains(str)) hs.add(str);
        }
        return answer;
    }
}