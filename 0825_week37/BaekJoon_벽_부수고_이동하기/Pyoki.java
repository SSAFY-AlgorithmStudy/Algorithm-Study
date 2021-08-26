import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int row;
		int col;
		int dist;
		int brk_wall;
		public Point(int row, int col, int dist, int brk_wall) {
			this.row = row;
			this.col = col;
			this.dist = dist;
			this.brk_wall = brk_wall;
		}
	}
	static int n, m;
	static int[][] map;
	static boolean[][][] visited;
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };
	static int answer;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean [n][m][2];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';		
			}
		}
		answer=Integer.MAX_VALUE;
		bfs();
		if(answer==Integer.MAX_VALUE) {
			System.out.println(-1);		
		}
		else
			System.out.println(answer);
	}
    
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
        visited[0][0][1]=true;
		visited[0][0][0]=true;
		q.add(new Point(0, 0, 1, 1));
		
        while (!q.isEmpty()) {
			Point p = q.poll();
			int row = p.row;
			int col = p.col;
			int dist = p.dist;
			int brk_wall = p.brk_wall;	
			if(row ==n-1 && col==m-1) {
				answer =dist;
                break;
			}		
			for (int k = 0; k < 4; k++) {
				int nrow = row + drow[k];
				int ncol = col + dcol[k];
				if (is_range(nrow, ncol)) {
					if (brk_wall == 1) {
						if (map[nrow][ncol] == 0 && !visited[nrow][ncol][1]) {
							visited[nrow][ncol][1]=true;
							q.add(new Point(nrow, ncol, dist + 1, brk_wall));
						} else if (map[nrow][ncol] == 1 && !visited[nrow][ncol][1]) {
							visited[nrow][ncol][1]=true;
							q.add(new Point(nrow, ncol, dist + 1, brk_wall - 1));
						}
					} else {
						if (map[nrow][ncol] == 0 && !visited[nrow][ncol][0]) {
							visited[nrow][ncol][0]=true;
							q.add(new Point(nrow, ncol, dist + 1, brk_wall));
						}
					}
				}
			}
		}
	}

	static boolean is_range(int row, int col) {
		if (0 <= row && row < n && 0 <= col && col < m) {
			return true;
		}
		return false;

	}

}

