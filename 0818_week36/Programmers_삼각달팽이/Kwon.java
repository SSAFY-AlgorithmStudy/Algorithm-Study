class Solution {
    public int[] solution(int n) {
        int[][] map = new int[n][n];
        
        int cur = 1;
        int end = n * (n + 1) / 2;
        int r = -1;
        int c = 0;
        int loop = n;
        
        while(cur <= end){
            for(int i = 0; i < loop; i++){
                map[++r][c] = cur++;
            }
            loop--;
            
            for(int i = 0; i < loop; i++){
                map[r][++c] = cur++;
            }
            loop--;
            
            for(int i = 0; i < loop; i++){
                map[--r][--c] = cur++;
            }
            loop--;
        }
        
        int index = 0;
        int[] answer = new int[end];
        for(int R = 0; R < n; R++){
            for(int C = 0; C <= R; C++){
                answer[index++] = map[R][C];
            }
        }
        
        return answer;
    }
}