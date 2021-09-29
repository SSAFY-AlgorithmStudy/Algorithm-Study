import java.io.*;
import java.util.*;

public class Kwon {

	static class Pos {
		int r;
		int c;
		int d;

		public Pos(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	static int N, K, L;
	static int[][] map;
	static int[] times;
	static char[] directions;
	static Deque<Pos> snakes = new LinkedList<>();
	static final int SNAKE = 1;
	static final int APPLE = 2;
	static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.valueOf(bf.readLine());
		K = Integer.valueOf(bf.readLine());
		map = new int[N][N];
		for (int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());

			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;

			map[r][c] = APPLE;
		}

		L = Integer.valueOf(bf.readLine());
		times = new int[L];
		directions = new char[L];
		for (int l = 0; l < L; l++) {
			String[] input = bf.readLine().split(" ");

			times[l] = Integer.valueOf(input[0]);
			directions[l] = input[1].charAt(0);
		}

		snakes.addFirst(new Pos(0, 0, 0));
		map[0][0] = SNAKE;

		int time = 0;
		int index = 0;
		while (true) {
			Pos head = snakes.getFirst();

			int r = head.r;
			int c = head.c;
			int d = head.d;

			if (index < L && time == times[index]) {
				char direction = directions[index];
				if (direction == 'D')
					d = (d + 1) % 4;
				else
					d = d == 0 ? 3 : d - 1;
				index++;
			}

			time++;
			int nr = r + dirs[d][0];
			int nc = c + dirs[d][1];

			if (isOut(nr, nc) || map[nr][nc] == SNAKE)
				break;

			if (map[nr][nc] != APPLE) {
				Pos tail = snakes.pollLast();
				map[tail.r][tail.c] = 0;
			}

			map[nr][nc] = SNAKE;
			snakes.addFirst(new Pos(nr, nc, d));
		}

		System.out.println(time);
	}

	private static boolean isOut(int r, int c) {
		return r < 0 || c < 0 || r > N - 1 || c > N - 1;
	}
}