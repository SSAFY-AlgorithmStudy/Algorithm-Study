import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
      
        ArrayList<Integer> res = new ArrayList<>();
        int [] progresses_use = new int[progresses.length];
        for(int i=0;i<progresses.length;i++){
               progresses_use[i] =progresses[i];
            }
        boolean [] deploy_possible = new boolean[progresses.length];
        boolean [] deploy = new boolean[progresses.length];
        int deploy_idx =0;
       
        while(true){
          
            if(finish(deploy))break;
            
            for(int i=0;i<speeds.length;i++){
                progresses_use[i]+=speeds[i];
                 if(progresses_use[i]>=100){
                    deploy_possible[i]=true;
                }
            }
            
            int cnt=0;
            if(deploy_possible[deploy_idx] && !deploy[deploy_idx]){
              if(deploy_idx==0){
                  deploy[deploy_idx]=true;
                  deploy_idx++;
                  cnt++;
                  for(int k=deploy_idx;k<progresses.length;k++){
                      if(deploy_possible[k]&&!deploy[k]&&deploy[k-1]){
                          deploy[k] =true;
                          deploy_idx++;
                          cnt++;
                      }
                  }
              }
                else{
                      for(int k=deploy_idx;k<progresses.length;k++){
                      if(deploy_possible[k]&&!deploy[k]&&deploy[k-1]){
                          deploy[k] =true;
                          deploy_idx++;
                          cnt++;
                      }
                  }
                }
                res.add(cnt);
            }
        }
        int[] answer = new int [res.size()];
        for(int i=0;i<res.size();i++){
            answer[i]=res.get(i);
        }
        return answer;
        }
        
    static boolean finish(boolean [] deploy){     
        for(int k=0;k<deploy.length;k++){
            if(!deploy[k])return false;
        }
        return true;
        }
    }