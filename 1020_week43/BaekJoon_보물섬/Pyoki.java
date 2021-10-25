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
		int time;

		public Point(int row, int col, int time) {
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}

	static char[][] map;
	static boolean[][] visited;
	static int R, C;
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };
	static int Answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Answer = Integer.MIN_VALUE;
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		// bfs 탐색시 최단 거리 보장
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'L' && !visited[i][j]) {
					solve(i, j);
				}

				// visited초기화
				for (int l = 0; l < R; l++) {
					for (int k = 0; k < C; k++) {
						visited[l][k] = false;
					}
				}

			}
		}
		System.out.println(Answer);
	}

	public static void solve(int r, int c) {

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c, 0));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			int row = p.row;
			int col = p.col;
			int time = p.time;
			if (time > Answer) {
				Answer = time;
			}
			for (int k = 0; k < 4; k++) {
				int nrow = row + drow[k];
				int ncol = col + dcol[k];
				if (isRange(nrow, ncol)) {
					// 방문 하지않았고 육지일경우.
					if (!visited[nrow][ncol] && map[nrow][ncol] == 'L') {
						visited[nrow][ncol] = true;
						q.add(new Point(nrow, ncol, time + 1));
					}
				}
			}

		}

	}

	// map 배열인덱스 벗어나는지 체크
	public static boolean isRange(int nrow, int ncol) {
		if (0 <= nrow && nrow < R && 0 <= ncol && ncol < C)
			return true;

		return false;
	}

} // end of class

