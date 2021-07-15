class Solution {
    
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = s2t(play_time);
        int[]totalTime = new int[playTime + 1];
        
        for(String log : logs){
            String[] logArr = log.split("-");
            
            int startTime = s2t(logArr[0]);
            int endTime = s2t(logArr[1]);
            
            totalTime[startTime]++;
            totalTime[endTime]--;
        }
        
        for(int i = 0; i < playTime; i++){
            totalTime[i + 1] += totalTime[i];
        }        
        
        int advTime = s2t(adv_time);
        int maxIndex = 0;
        long maxView = 0;
        for(int i = 0; i < advTime; i++){
            maxView += totalTime[i];
        }
        
        long curView = maxView;
        for(int i = advTime; i <= playTime; i++){
            curView = curView - totalTime[i - advTime] + totalTime[i];
            
            if(curView > maxView){
                maxView = curView;
                maxIndex = i - advTime + 1;
            }
        }
        
        return String.format("%02d:%02d:%02d", maxIndex / 3600, maxIndex / 60 % 60, maxIndex % 60);
    }
    
    public int s2t(String time){
        String[] timeArr = time.split(":");
        
        return Integer.valueOf(timeArr[0]) * 60 * 60 
            + Integer.valueOf(timeArr[1]) * 60
            + Integer.valueOf(timeArr[2]);
    }
}