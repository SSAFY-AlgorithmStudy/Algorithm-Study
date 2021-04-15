class Solution {
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        visited = new boolean[n];
        
        for(int start = 0; start < n; start++){
            if(!visited[start]){
                answer++;
                goNext(n, start, computers);
            }
        }
        
        return answer;
    }
    
    public void goNext(int n, int cur, int[][] computers){
        visited[cur] = true;
        
        for(int next = 0; next < n; next++){
            if(computers[cur][next] == 1 && !visited[next]){
                goNext(n, next, computers);
            }
        }
    }
}
