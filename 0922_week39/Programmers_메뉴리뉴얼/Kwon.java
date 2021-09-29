import java.util.*;

class Kwon {
    
    ArrayList<String> answer = new ArrayList<>();
    HashMap<String, Integer> setCounts = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        for(String order : orders){
            int size = order.length();
            
            char[] sub = order.toCharArray();
            Arrays.sort(sub);
            StringBuilder sb = new StringBuilder();
            for(char ele : sub) sb.append(ele);
            order = sb.toString();
            
            for(int i : course){
                makeSet(0, 0, i, "", order);
            }
        }
        
        HashMap<Integer, Integer> maxCountPerSet = new HashMap<>();
        for(String set : setCounts.keySet()){
            int length = set.length();
            int cnt = setCounts.get(set);
            
            maxCountPerSet.put(length, Math.max(maxCountPerSet.getOrDefault(length, 0), cnt));
        }
        
        for(int length : maxCountPerSet.keySet()){
            int size = maxCountPerSet.get(length);
            
            if(size < 2) continue;
            
            for(String set : setCounts.keySet()){
                if(set.length() == length && setCounts.get(set) == size){
                    answer.add(set);
                }
            }
        }
        
        int index = 0;
        String[] ret = new String[answer.size()];
        for(String a : answer){
            ret[index++] = a;
        }
        Arrays.sort(ret);
        
        return ret;
    }
    
    public void makeSet(int cnt, int cur, int M, String set, String order){
        if(cnt == M){
            setCounts.put(set, setCounts.getOrDefault(set, 0) + 1);
            return;
        }
        for(int i = cur; i < order.length(); i++){
            makeSet(cnt + 1, i + 1, M, set + order.charAt(i), order);
        }
    }
}