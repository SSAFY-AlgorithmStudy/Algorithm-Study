import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_16197 {
	static class Game {
		int coin1Row;
		int coin1Col;
		int coin2Row;
		int coin2Col;
		int cnt;
		
		public Game(int coin1Row,int coin1Col, int coin2Row, int coin2Col,  int cnt) {
			this.coin1Row=coin1Row;
			this.coin1Col=coin1Col;			
			this.coin2Row=coin2Row;
			this.coin2Col=coin2Col;
			this.cnt = cnt;
		}
	}

	static class Coin {
		int row;
		int col;

		public Coin(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static int N, M;
	static char[][] map;
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		ArrayList<Coin> cp = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'o') {
					cp.add(new Coin(i, j));

				}
			}
		}
		int answer = bfs(cp);
		System.out.println(answer);
	}

	static int bfs(ArrayList<Coin> cp) {

		int res = 0;
		Queue<Game> q = new LinkedList<>();
		
		q.add(new Game(cp.get(0).row,cp.get(0).col,cp.get(1).row,cp.get(1).col, 0));

		while (!q.isEmpty()) {
			Game g = q.poll();
			int coin1Row=g.coin1Row;
			int coin1Col=g.coin1Col;
			int coin2Row=g.coin2Row;
			int coin2Col=g.coin2Col;
			int cnt = g.cnt;

			int fallCnt = 0;
			if(coin1Row==-1)fallCnt++;
			if(coin2Row==-1)fallCnt++;
			if (fallCnt == 1) {
				res = cnt;
				break;
			}
			if(cnt >10) {
				res =-1;
				break;
			}
			if (fallCnt == 0) {
				for (int k = 0; k < 4; k++) {
					int n_coin1_row =coin1Row;
					int n_coin1_col =coin1Col;
					int n_coin2_row =coin2Row;
					int n_coin2_col =coin2Col;
					
					//coin1
					int nrow_coin1= coin1Row+drow[k];
					int ncol_coin1= coin1Col+dcol[k];
					if(isRange(nrow_coin1,ncol_coin1)) {
						if (map[nrow_coin1][ncol_coin1] != '#') {
							n_coin1_row=nrow_coin1;
							n_coin1_col=ncol_coin1;
						}
					}
					else {
						n_coin1_row=-1;
						n_coin1_col=-1;
					}
					
					//coin2
					int nrow_coin2= coin2Row+drow[k];
					int ncol_coin2= coin2Col+dcol[k];
					if(isRange(nrow_coin2,ncol_coin2)) {
						if (map[nrow_coin2][ncol_coin2] != '#') {
							n_coin2_row=nrow_coin2;
							n_coin2_col=ncol_coin2;
						}
					}
					else {
						n_coin2_row=-1;
						n_coin2_col=-1;
					}
					
					q.add(new Game(n_coin1_row,n_coin1_col,n_coin2_row,n_coin2_col,cnt + 1));
				}
			}
		}
		return res;
	}

	static boolean isRange(int nrow, int ncol) {
		if (0 <= nrow && nrow < N && 0 <= ncol && ncol < M)
			return true;

		return false;
	}

}
