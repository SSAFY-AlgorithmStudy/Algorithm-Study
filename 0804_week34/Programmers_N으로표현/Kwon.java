import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int num = N;
        
        HashMap<Integer, ArrayList<Integer>> p = new HashMap<>();
        HashSet<Integer> already = new HashSet<>();
        
        for(int i = 1; i <= 8; i++){
            p.put(i, new ArrayList<>());
            p.get(i).add(num);
            already.add(num);
            
            if(num == number){
                return i;
            }
            
            num = num * 10 + N;
        }
        
        for(int i = 2; i <= 8; i++){
            for(int one = 1; one <= i / 2; one++){
                int two = i - one;
                
                for(int o : p.get(one)){
                    for(int t : p.get(two)){
                        for(int op = 0; op < 4; op++){
                            int cur = calc(t, o, op);
                            
                            if(!already.add(cur) || isOut(cur)) continue;
                            
                            p.get(i).add(cur);
                            
                            if(cur == number){
                                return i;
                            }
                        }
                    }
                }
            }
        }
        
        return -1;
    }
    
    public int calc(int a, int b, int op){
        if(op == 0) return a + b;
        else if(op == 1) return a * b;
        else if(op == 2) return a / b;
        else  return Math.abs(a - b);
    }
    
    public boolean isOut(int num){
        return num <= 0 || num > 32000;
    }
}