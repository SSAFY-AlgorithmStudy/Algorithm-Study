import java.util.*;

class Solution {
   
    public String solution(int[] numbers) {
        String answer = "";
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer x1, Integer x2){
                String num1Str = Integer.toString(x1);
                String num2Str = Integer.toString(x2);
                String mergeNum1 = num1Str+num2Str;
                String mergeNum2 = num2Str+num1Str;
                int a = Integer.parseInt(mergeNum1);
                int b = Integer.parseInt(mergeNum2);
                return -(a-b);
            } 
        });
        
        for(int x : numbers){
            pq.add(x);
        }
        while(!pq.isEmpty()){
           answer += pq.poll();
        }
        if(answer.charAt(0)=='0'){
        int zeroCheck = Integer.parseInt(answer);
        String ans = Integer.toString(zeroCheck);
        answer = ans;
        }
        return answer;
    }
}