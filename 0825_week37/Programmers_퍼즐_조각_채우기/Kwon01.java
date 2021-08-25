import java.util.*;

class Solution {
    
    class Pos{
        int r;
        int c;
        
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    int N, answer;
    int[][] Table;
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    
    public int solution(int[][] game_board, int[][] table) {
        N = game_board.length;
        answer = 0;
        Table = table;
        
        boolean[][] visited = new boolean[N][N];
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                if(game_board[r][c] == 0 && !visited[r][c]){
                    String hole = find(r, c, game_board, visited, 0);
                    
                    if(findSamePuzzle(hole)){
                        answer += getSize(hole);
                    }
                }
            }
        }
        
        return answer;
    }
    
    public String find(int R, int C, int[][] map, boolean[][] visited, int flag){
        StringBuilder sb = new StringBuilder();
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(R, C));
        
        while(!q.isEmpty()){
            Pos cur = q.poll();
            
            int r = cur.r;
            int c = cur.c;
            
            if(visited[r][c]) continue;
            visited[r][c] = true;
            
            // 퍼즐들의 상대위치를 문자열로 저장해서 비교, 퍼즐의 크기 = '/' 갯수 + 1
            sb.append(r - R).append(',').append(c - C).append('/');
            
            for(int i = 0; i < 4; i++){
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                
                // game_board일떈 0 찾기, table일땐 1찾기
                if(isOut(nr, nc) || map[nr][nc] != flag || visited[nr][nc]) continue;
            
                q.add(new Pos(nr, nc));
            }
        }
        
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
    
    public boolean findSamePuzzle(String answer){
        for(int d = 0; d < 4; d++){
            Table = rotate(Table);
            boolean[][] visited = new boolean[N][N];
            for(int r = 0; r < N; r++){
                for(int c = 0; c < N; c++){
                    if(Table[r][c] == 1 && !visited[r][c]){
                        String puzzle = find(r, c, Table, visited, 1);
                        
                        if(answer.equals(puzzle)){
                            removeTable(puzzle, r, c);
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean isOut(int r, int c){
        return r < 0 || c < 0 || r > N - 1 || c > N - 1;
    }
    
    public int[][] rotate(int[][] table){
        int[][] ret = new int[N][N];
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                ret[r][c] = table[N - c - 1][r];
            }
        }
        
        return ret;
    }
    
    // 상대위치 -> 절대위치로 변환
    public void removeTable(String route, int R, int C){
        String[] poses = route.split("/");
        for(String pos : poses){
            String[] rc = pos.split(",");
            
            int r = Integer.valueOf(rc[0]) + R;
            int c = Integer.valueOf(rc[1]) + C;
            
            Table[r][c] = 0;
        }
    }
    
    public int getSize(String route){
        String[] poses = route.split("/");
        return poses.length;
    }
}