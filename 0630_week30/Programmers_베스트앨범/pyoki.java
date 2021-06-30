import java.util.*;

class Solution {
    static class Song{
        int idx;
        int plays;
        int total;
        String genre;
        public Song(int idx,int plays,int total,String genre){
            this.idx=idx;
            this.plays=plays;
            this.total = total;
            this.genre= genre;
        }
    }
    static HashMap<String, Integer> hm;
    public int[] solution(String[] genres, int[] plays) {
      
        hm = new HashMap<>();
       
        for(int i=0;i<genres.length;i++){
           if (hm.containsKey(genres[i])) {
               int cnt = hm.get(genres[i]);
               hm.put(genres[i],cnt+plays[i]);
                
            } 
            else{
             hm.put(genres[i],plays[i]);
           }
        }
        
        PriorityQueue<Song> pq = new PriorityQueue<>(new Comparator<Song>(){
            @Override
            public int compare(Song s1, Song s2){
                
                if(s1.total== s2.total){
                    
                    if(s1.plays== s2.plays){
                        return s1.idx-s2.idx;
                    }
                    return -(s1.plays-s2.plays);
                }
                
                return -(s1.total-s2.total);
            }
            
        });
        for(int i=0;i<plays.length;i++){
            pq.add(new Song(i,plays[i],hm.get(genres[i]),genres[i]));
            
        }
        ArrayList<Integer> res = new ArrayList<>();
        
        int songCnt =0;
        Song sq = pq.peek();
        String tempGe =sq.genre;
        while(!pq.isEmpty()){
            Song s =pq.poll();
            int idx =s.idx;
            songCnt++;
      
            if(!tempGe.equals(s.genre)){
                songCnt=1;
                tempGe = s.genre;
                
            }
            
            if(songCnt<=2) res.add(idx);
       
        }
         int[] answer = new int[res.size()];
        for(int k=0;k<res.size();k++){
         answer[k]= res.get(k);   
        }
        
        return answer;
    }
}