import java.io.*;
import java.util.*;

public class Kwon {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][M + 1];

		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(bf.readLine());
			for (int c = 1; c <= M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				int cur = map[r][c];
				map[r][c] = Math.max(map[r][c], cur + map[r][c - 1]);
				map[r][c] = Math.max(map[r][c], cur + map[r - 1][c]);
				map[r][c] = Math.max(map[r][c], cur + map[r][c - 1]);
			}
		}

		System.out.println(map[N][M]);
	}
}