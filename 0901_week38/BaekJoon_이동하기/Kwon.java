import java.util.*;

class Kwon {
    
    class Robot{
        int minR, minC; // 왼(위)쪽 날개 좌표
        int maxR, maxC; // 오른(아래)쪽 날개 좌표
        boolean isHorizontal; // 누워있는지
        int cnt;
        
        public Robot(int nr, int nc, int xr, int xc, boolean h, int cnt){
            this.minR = Math.min(nr, xr);
            this.minC = Math.min(nc, xc);
            this.maxR = Math.max(nr, xr);
            this.maxC = Math.max(nc, xc);
            this.isHorizontal = h;
            this.cnt = cnt;
        }
    }
    
    int N, M;
    boolean[][][][] visited;
    int[][] dirs = {{-1, 0} ,{1, 0}, {0, 1}, {0, -1}};
    
    public int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        M = board[0].length;
        visited = new boolean[N][M][N][M];
        
        Queue<Robot> q = new LinkedList<>();
        q.add(new Robot(0, 0, 0, 1, true, 0));
        
        while(!q.isEmpty()){
            Robot cur = q.poll();
            
            int minR = cur.minR; 
            int minC = cur.minC;
            int maxR = cur.maxR;
            int maxC = cur.maxC;
            int cnt = cur.cnt;
            boolean isHorizontal = cur.isHorizontal;
            
            if(maxR == N - 1 && maxC == M - 1){
                answer = cnt;
                break;
            }
            
            if(visited[minR][minC][maxR][maxC]) 
                continue;
            visited[minR][minC][maxR][maxC] = true;
            
            for(int[] dir : dirs){
                int nnr = minR + dir[0];
                int nnc = minC + dir[1];
                int nxr = maxR + dir[0];
                int nxc = maxC + dir[1];
                
                if(isOut(nnr, nnc) || isOut(nxr, nxc) || board[nnr][nnc] == 1 || board[nxr][nxc] == 1)
                    continue;
                
                q.add(new Robot(nnr, nnc, nxr, nxc, isHorizontal, cnt + 1));
                
                if((isHorizontal && minR != nnr) || (!isHorizontal && minC != nnc)){
                    q.add(new Robot(minR, minC, nnr, nnc, !isHorizontal, cnt + 1));
                    q.add(new Robot(maxR, maxC, nxr, nxc, !isHorizontal, cnt + 1));
                }
            }
        }
        
        return answer;
    }
    
    public boolean isOut(int r, int c){
        return r < 0 || c < 0 || r > N - 1 || c > M - 1;
    }
}