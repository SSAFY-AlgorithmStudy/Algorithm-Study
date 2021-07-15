class Solution {
    
    final int[] lengths = { 5, 8, 10 };
    final int[][] patterns = { { 1, 2, 3, 4, 5}, { 2, 1, 2, 3, 2, 4, 2, 5}, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }};
    
    public int[] solution(int[] answers) {
        int[] scores = new int[3];
        for(int i = 0; i < answers.length; i++){
            int answer = answers[i];
            
            if(answer == patterns[0][i % lengths[0]]){
                scores[0]++;
            }
            
            if(answer == patterns[1][i % lengths[1]]){
                scores[1]++;
            }
            
            if(answer == patterns[2][i % lengths[2]]){
                scores[2]++;
            }
            
            
        }
        
        int M = 0;
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        for(int i = 0; i < 3; i++){
            if(scores[i] == maxScore){
                M++;
            }
        }
        
        int[] answer = new int[M];
        int index = 0;
        for(int i = 0; i < 3; i++){
            if(scores[i] == maxScore){
                answer[index++] = i + 1;
            }
        }
        
        return answer;
    }
}