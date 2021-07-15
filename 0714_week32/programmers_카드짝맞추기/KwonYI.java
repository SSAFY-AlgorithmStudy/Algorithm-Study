import java.util.*;

class Solution {
    
    class Pos{
        int r;
        int c;
        int cnt;
        
        public Pos(int r, int c, int t){
            this.r = r;
            this.c = c;
            this.cnt = t;
        }
    }
    
    int[][] Board;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int solution(int[][] board, int r, int c) {
        Board = board;
        return selectCard(r, c, 0);
    }
    
    public int selectCard(int r, int c, int flag){
        int answer = Integer.MAX_VALUE;
        for(int card = 1; card <= 6; card++){
            // 1. 이미 뽑은 카드면 넘어가
            if((flag & (1 << card)) != 0) continue;
            
            int index = 0;
            int[][] cards = new int[2][2];
            
            // 2. 카드 위치 저장
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    if(Board[i][j] == card){
                        cards[index][0] = i;
                        cards[index][1] = j;
                        index++;
                    }
                }
            }
            
            if(index == 0) continue; // 해당 카드가 없다
            
            // 3. 각 카드 위치로 이동수 계산
            int o1 = move(r, c, cards[0][0], cards[0][1]) + move(cards[0][0], cards[0][1], cards[1][0], cards[1][1]) + 2;
            int o2 = move(r, c, cards[1][0], cards[1][1]) + move(cards[1][0], cards[1][1], cards[0][0], cards[0][1]) + 2;
            
            // 4. 카드 뽑은거로 체크
            Board[cards[0][0]][cards[0][1]] = Board[cards[1][0]][cards[1][1]] = 0;
            
            // 5. 다음 카드로
            answer = Math.min(answer, o1 + selectCard(cards[1][0], cards[1][1], flag | (1 << card)));
            answer = Math.min(answer, o2 + selectCard(cards[0][0], cards[0][1], flag | (1 << card)));
            
            // 6. 카드 다시 원래대로
            Board[cards[0][0]][cards[0][1]] = Board[cards[1][0]][cards[1][1]] = card;
        }
        
        // 이미 뽑은 카드들이야
        if(answer == Integer.MAX_VALUE) answer = 0;
        
        return answer;
    }
    
    public int move(int R, int C, int tr, int tc){
        int moveCnt = 0;
        boolean[][] visited = new boolean[4][4];
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(R, C, 0));
        
        while(!q.isEmpty()){
            Pos cur = q.poll();
            
            int r = cur.r;
            int c = cur.c;
            int cnt = cur.cnt;
            
            if(r == tr && c == tc){
                moveCnt = cnt;
                break;
            }
            
            if(visited[r][c]) continue;
            visited[r][c] = true;
            
            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if(isOut(nr, nc) || visited[nr][nc]) continue;
                q.add(new Pos(nr, nc , cnt + 1));
                
                while(true){
                    // 해당 위치가 카드면 멈춰
                    if(Board[nr][nc] != 0) break;
                    
                    int nnr = nr + dir[0];
                    int nnc = nc + dir[1];
                    
                    // 맵 벗어나면 멈춰
                    if(isOut(nnr, nnc)) break;
                    
                    nr = nnr;
                    nc = nnc;
                }
                
                q.add(new Pos(nr, nc , cnt + 1));
            }
        }
        
        return moveCnt;
    }
    
    public boolean isOut(int r, int c){
        return r < 0 || c < 0 || r > 3 || c > 3;
    }
}