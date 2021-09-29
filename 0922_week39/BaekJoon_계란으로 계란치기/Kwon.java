import java.util.*;
import java.io.*;

public class Kwon {

	static int N;
	static int answer = 0;
	static int[][] eggs;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.valueOf(bf.readLine());

		eggs = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());

			eggs[i][0] = Integer.parseInt(st.nextToken());
			eggs[i][1] = Integer.parseInt(st.nextToken());
		}

		solve(0);

		System.out.println(answer);
	}

	public static void solve(int cur) {
		if (cur == N) {
			int cnt = 0;
			for (int[] egg : eggs) {
				if (egg[0] <= 0)
					cnt++;
			}

			answer = Math.max(answer, cnt);
			return;
		}

		if (eggs[cur][0] <= 0 || allBroken()) {
			solve(cur + 1);
			return;
		}

		boolean flag = false;
		for (int i = 0; i < N; i++) {
			if (i == cur || eggs[i][0] <= 0) {
				continue;
			}

			eggs[cur][0] -= eggs[i][1];
			eggs[i][0] -= eggs[cur][1];
			flag = true;

			solve(cur + 1);

			eggs[cur][0] += eggs[i][1];
			eggs[i][0] += eggs[cur][1];
		}

		if (!flag)
			solve(cur + 1);

	}

	public static boolean allBroken() {
		for (int[] egg : eggs) {
			if (egg[0] > 0)
				return false;
		}
		return true;
	}
}