import java.io.*;
import java.util.*;

public class Main {

	static int N, M, answer = 11;
	static char[][] map;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N + 2][M + 2];

		int index = 0;
		int[][] coins = new int[2][2];

		for (int r = 1; r <= N; r++) {
			String input = bf.readLine();
			for (int c = 1; c <= M; c++) {
				map[r][c] = input.charAt(c - 1);
				if (map[r][c] == 'o') {
					coins[index][0] = r;
					coins[index][1] = c;
					index++;
				}
			}
		}

		dfs(0, coins);

		System.out.println(answer == 11 ? -1 : answer);
	}

	private static void dfs(int cnt, int[][] coins) {
		if (cnt > answer || stopGame(coins)) return;

		if (endGame(coins)) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		for (int[] dir : dirs) {
			int[][] newCoin = new int[2][2];

			for (int index = 0; index < 2; index++) {
				int nr = coins[index][0] + dir[0];
				int nc = coins[index][1] + dir[1];

				if (nr < 0 || nr > N + 1 || nc < 0 || nc > M + 1) {
					return;
				}
				
				if (map[nr][nc] == '#') {
					newCoin[index][0] = coins[index][0];
					newCoin[index][1] = coins[index][1];
				} else {
					newCoin[index][0] = nr;
					newCoin[index][1] = nc;
				}
			}

			dfs(cnt + 1, newCoin);
		}
	}

	private static boolean stopGame(int[][] coins) {
		return isOut(coins[0][0], coins[0][1]) && isOut(coins[1][0], coins[1][1]);
	}

	private static boolean endGame(int[][] coins) {
		return isOut(coins[0][0], coins[0][1]) ^ isOut(coins[1][0], coins[1][1]);
	}

	public static boolean isOut(int r, int c) {
		return r < 1 || r > N || c < 1 || c > M;
	}
}