import java.util.*;

class Kwon {
    
    class Taxi implements Comparable<Taxi>{
        int to;
        int price;
        
        public Taxi(int to, int price){
            this.to = to;
            this.price = price;
        }
        
        public int compareTo(Taxi o){
            return this.price - o.price;
        }
    }
    
    final int INF = 987654321;
    ArrayList<Taxi> taxis[];
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        taxis = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            taxis[i] = new ArrayList<>();
        }
        
        for(int[] fare : fares){
            int from = fare[0];
            int to = fare[1];
            int price = fare[2];
            
            taxis[from].add(new Taxi(to, price));
            taxis[to].add(new Taxi(from, price));
        }
        
        int[] fromS = findMinPrice(s, n);
        int[] toA = findMinPrice(a, n);
        int[] toB = findMinPrice(b, n);
        
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            if(fromS[i] == INF || toA[i] == INF || toB[i] == INF)
                continue;
            
            answer = Math.min(answer, fromS[i] + toA[i] + toB[i]);
        }
        
        return answer;
    }
    
    public int[] findMinPrice(int start, int size){
        int[] ret = new int[size + 1];
        for(int i = 1; i <= size; i++){
            ret[i] = INF;
        }
        
        PriorityQueue<Taxi> pq = new PriorityQueue<>();
        pq.add(new Taxi(start, 0));
        ret[start] = 0;
        
        while(!pq.isEmpty()){
            int cur = pq.poll().to;
            
            for(Taxi next : taxis[cur]){
                if(ret[next.to] > ret[cur] + next.price){
                    ret[next.to] = ret[cur] + next.price;
                    pq.add(new Taxi(next.to, ret[next.to]));
                }
            }
        }
        
        return ret;
    } 
}