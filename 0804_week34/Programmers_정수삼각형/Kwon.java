class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for(int r = 1; r < triangle.length; r++){
            
            int m = triangle[r].length;
            
            for(int c = 0; c < m; c++){
                
                if( c == 0 ){ // 젤 오른쪽
                    triangle[r][c] = triangle[r][c] + triangle[r-1][c];
                }else if( c == m - 1){ // 젤 왼쪽
                    triangle[r][c] = triangle[r][c] + triangle[r-1][c-1];
                }else{ // 그 사이
                    triangle[r][c] = Math.max(triangle[r][c] + triangle[r - 1][c - 1], 
                                              triangle[r][c] + triangle[r - 1][c]);
                }
                
                answer = Math.max(answer, triangle[r][c]);
            }
        }
        
        return answer;
    }
}