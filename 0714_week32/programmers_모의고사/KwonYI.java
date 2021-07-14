import java.util.*;

class Solution {
    
    class Place implements Comparable<Place>{
        int to;
        int fare;
        
        public Place(int to, int fare){
            this.to = to;
            this.fare = fare;
        }
        
        public int compareTo(Place o){
            return this.fare - o.fare;
        }
    }
    
    int[] toA, toB, fromS;
    ArrayList<Place>[] infos;
    PriorityQueue<Place> pq = new PriorityQueue<>();
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        toA = new int[n + 1];
        toB = new int[n + 1];
        fromS = new int[n + 1];
        infos = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++){
            toA[i] = toB[i] = fromS[i] = 200000000;
            infos[i] = new ArrayList<>();
        }
        
        for(int[] fare : fares){
            int from = fare[0];
            int to = fare[1];
            int price = fare[2];
            
            infos[from].add(new Place(to, price));
            infos[to].add(new Place(from, price));
        }
        
        toA[a] = toB[b] = fromS[s] = 0;
       
        find(a, 0, toA);
        find(b, 0, toB);
        find(s, 0, fromS);
        
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            int total = toA[i] + toB[i] + fromS[i];
            answer = Math.min(answer, total);
        }
        
        return answer;
    }
    
    public void find(int start, int price, int[] arr){
        pq.add(new Place(start, price));
        
        while(!pq.isEmpty()){
            Place cur = pq.poll();
            
            int from = cur.to;
            
            for(Place next : infos[from]){
                if(arr[next.to] > arr[from] + next.fare){
                    arr[next.to] = arr[from] + next.fare;
                    pq.add(new Place(next.to, arr[next.to]));
                }
            }
        }
    }
}