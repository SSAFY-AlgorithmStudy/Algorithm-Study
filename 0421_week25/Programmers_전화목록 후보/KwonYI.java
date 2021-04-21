import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book, new Comparator<>(){
            public int compare(String o1, String o2){
                return o1.length() - o2.length();
            }
        });
            
        
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < phone_book.length; i++){
            String cur = phone_book[i];
            
            for(int j = 1; j <= cur.length(); j++){
                String sub = cur.substring(0, j);
                if(set.contains(sub)){
                    return false;
                }
            }
            set.add(cur);
        }
        
        return true;
    }
}