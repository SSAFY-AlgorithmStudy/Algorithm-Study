package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.sql.rowset.serial.SQLOutputImpl;

public class Main_17086_아기상어2 {

	public static int dr[] = { 0, 0, 1, -1, 1, 1, -1, -1 };
	public static int dc[] = { 1, -1, 0, 0, 1, -1, -1, 1 };

	public static int N;
	public static int M;
	public static boolean visited[][];

	public static class Pair {
		int r;
		int c;
		int count;

		public Pair(int r, int c, int count) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
		}
	}// end of pair class

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int arr[][] = new int[N][M];
		int answer = Integer.MIN_VALUE;
		visited = new boolean[N][M];

		// 입력하기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 0이면 bfs돌리기 
		for(int i= 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				 if(arr[i][j] == 0) {
					int k = bfs(arr,i,j,0);
					answer = Math.max(k, answer);
				 }else {
					 continue; 
				 }
			}
		}


		System.out.println(answer);

	}

	private static int bfs(int[][] arr, int r, int c, int count) {

		visited = new boolean[N][M];
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(r, c, count));
		visited[r][c] = true;
	
		while (!queue.isEmpty()) {
			Pair p = queue.poll();

			for (int i = 0; i < 8; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc]) {
					if (arr[nr][nc] == 1) {	
						return p.count + 1;
					}
					visited[nr][nc] = true;
					queue.add(new Pair(nr, nc, p.count+1));
				} // end of if
			}
		}

		return 0;
	}

}// end of class
