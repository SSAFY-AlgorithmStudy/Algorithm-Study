class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int area = brown + yellow;
        
        for(int c = 3; c <= area / 3; c++){
            if(area % c != 0){
                continue;
            }
            
            int r = area / c;
            
            if(2*r + 2*c - 4 == brown){
                answer[0] = r;
                answer[1] = c;
                break;
            }
        }
        return answer;
    }
}
