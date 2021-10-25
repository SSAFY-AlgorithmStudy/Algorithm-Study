import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<win_nums.length;i++){
            if(!hs.contains(win_nums[i])){
                hs.add(win_nums[i]);
            }
        }
        int zeroCnt = 0;
        int winCnt =0;
        for(int i=0;i<lottos.length;i++){
            if(lottos[i]==0) zeroCnt++;
            if(hs.contains(lottos[i])){
                winCnt++;
            }
        }
        int maxWinCnt = winCnt+zeroCnt;
        int minWinCnt = winCnt;
        if(maxWinCnt==0) maxWinCnt=1;
        if(minWinCnt==0) minWinCnt=1;
        answer[0] = 7-maxWinCnt;
        answer[1] = 7-minWinCnt; 
        return answer;
    }
}
