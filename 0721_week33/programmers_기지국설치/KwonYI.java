import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = 0;
        int prev = 1;
        int length = 2 * w + 1;
        
        while(true){
            if(index == stations.length){
                int last = n - stations[index - 1] + w;
                if(last < n){
                    answer += build(n - last, length);
                }
                break;
            }
            
            while(index < stations.length && stations[index] - w < prev){
                index++;
            }
            
            int left = stations[index] - w;
            answer += build(prev - left, length);
        	prev = stations[index] + w + 1;
            index++;
        }
        
        return answer;
    }
    
    public int build(int length, int width){
        if(length % width == 0) return length / width;
        else return length / width + 1;
    }
}