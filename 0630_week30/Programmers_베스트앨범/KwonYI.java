import java.util.*;

class Solution {
    
    class Music implements Comparable<Music>{
        int index;
        int play;
        String genre;
        
        public Music(int i, int p, String g){
            this.index = i;
            this.play = p;
            this.genre = g;
        }
        
        public int compareTo(Music o){
            if(this.play == o.play) return this.index - o.index;
            return o.play - this.play;
        }
    }
    
    HashMap<String, Integer> totalPlay = new HashMap<>();
    HashMap<String, PriorityQueue<Music>> playByMusic = new HashMap<>();
    
    public int[] solution(String[] genres, int[] plays) {
        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            totalPlay.put(genre, totalPlay.getOrDefault(genre, 0) + play);
            
            // 장르 먼저 파고
            if(!playByMusic.containsKey(genre)){
                playByMusic.put(genre, new PriorityQueue<>());
            }
            // 거따가 음악 넣어주라
            playByMusic.get(genre).add(new Music(i, play, genre));
        }
        
        PriorityQueue<Music> pq = new PriorityQueue<>();
        for(String genre : totalPlay.keySet()){
            int play = totalPlay.get(genre);
            pq.add(new Music(0, play, genre));
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            String genre = pq.poll().genre;
            
            int cnt = 2;
            PriorityQueue<Music> sub = playByMusic.get(genre);
            
            while(!sub.isEmpty() && cnt-- != 0){
                int index = sub.poll().index;
                list.add(index);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}