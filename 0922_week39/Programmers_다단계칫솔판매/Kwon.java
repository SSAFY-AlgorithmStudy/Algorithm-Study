import java.util.*;

class Kwon {
    
    int N;
    int[] p, prices;
    HashMap<String, Integer> names = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        N = enroll.length;
        for(int i = 0; i < N; i++){
            names.put(enroll[i], i);
        }
        
        p = new int[N];
        for(int i = 0; i < N; i++){
            String master = referral[i];
            if("-".equals(master))
                p[i] = -1;
            else
                p[i] = names.get(master);
        }
        
        prices = new int[N];
        int m = seller.length;
        for(int i = 0; i < m; i++){
            String s = seller[i];
            int total = amount[i] * 100;
            int index = names.get(s);
            
            while(true){
                int notMine = (int)(total/(float)10);
                int mine = total - notMine;
                
                prices[index] += mine;
                index = p[index];
                
                if(index == -1)
                    break;
                else
                    total = notMine;
            }
        }
        
        return prices;
    }
}