package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {

	static int map[][], N, M, res = Integer.MAX_VALUE, dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean visited[][][];
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j) + "");
			}
		}
		if (map[0][0] == 0)
			bfs();

		if (res != Integer.MAX_VALUE)
			System.out.println(res);
		else
			System.out.println("-1");
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		q.add(new int[] { 0, 0, 1, 1 });
		visited[0][0][0] = true;
		visited[0][0][1] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			int move = tmp[2];
			// 남은 횟수
			int cnt = tmp[3];

			if (r == N - 1 && c == M - 1) {
				res = Math.min(move, res);
			}

			for (int i = 0; i < dir.length; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				else {
					// 벽인경우
					if (map[nr][nc] == 1&&cnt == 1 && !visited[nr][nc][1]) {
							visited[nr][nc][1] = true;
							q.add(new int[] { nr, nc, move + 1, 0 });
					} else if (map[nr][nc] == 0&&!visited[nr][nc][cnt]) {
							visited[nr][nc][cnt] = true;
							q.add(new int[] { nr, nc, move + 1, cnt });		
						}
					}
				
				}
			

		}
	}

}
