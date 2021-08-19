import java.util.*;

class Solution {
    public String solution(int[][] scores) {
        int studentNum = scores.length;
        StringBuilder answer = new StringBuilder();
        
        for(int my = 0; my < studentNum; my++){
            float totalScore = 0;
            int maxScore = 0, minScore = 101;
            HashMap<Integer, Integer> myScores = new HashMap<>();
            
            for(int other = 0; other < studentNum; other++){
                int score = scores[other][my];
                totalScore += score;
                myScores.put(score, myScores.getOrDefault(score, 0) + 1);
                
                maxScore = Math.max(maxScore, score);
                minScore = Math.min(minScore, score);
            }
            
            int maxCnt = myScores.get(maxScore);
            int minCnt = myScores.get(minScore);
            
            if(maxScore == minScore){
                totalScore /= studentNum; 
            }else{
                int myScore = scores[my][my];
                if(myScore == maxScore && maxCnt == 1){
                    totalScore -= maxScore;
                    totalScore /= (studentNum - 1);
                }else if(myScore == minScore && minCnt == 1){
                    totalScore -= minScore;
                    totalScore /= (studentNum - 1);
                }else{
                    totalScore /= studentNum;
                }
            }
            
            answer.append(getScore(totalScore));
        }
        
        return answer.toString();
    }
    
    public char getScore(float score){
        char ret;
        
        if(score >= 90)
            ret = 'A';
        else if(score >= 80)
            ret = 'B';
        else if(score >= 70)
            ret = 'C';
        else if(score >= 50)
            ret = 'D';
        else 
            ret = 'F';
            
        return ret;
    }
}