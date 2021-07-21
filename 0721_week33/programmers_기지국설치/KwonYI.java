class Solution {
    public int solution(int n, int[] stations, int w) {
        int length = 2 * w + 1;
        int prev = 0;
        int index = 0;
        int answer = 0;
        
        for(int i = 0; i < stations.length; i++){
            int cur = stations[i];
            int left = cur - w;
            int right = cur + w;
                
            if(prev < left){
                answer += build(left - prev - 1, length);
            }
            
            prev = right;
        }
        
        if(prev < n){
            answer += build(n - prev, length);
        }
        
        return answer;
    }
    
    public int build(int length, int width){
        int ret = length / width;
        if(length % width != 0) {
            ret++;
        }
        return ret;
    }
}