import java.io.*;
import java.util.*;

public class Main {

	static class Pos {
		int r;
		int c;
		int people;

		public Pos(int r, int c, int people) {
			this.r = r;
			this.c = c;
			this.people = people;
		}
	}

	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Pos> unions = new LinkedList<>();
	static final int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(bf.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int day = 0;
		while (opening()) {
			move();
			day++;
		}

		System.out.println(day);
	}

	private static boolean opening() {
		int unionCnt = 0;
		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c]) {
					makeUnion(r, c);
					unionCnt++;
				}
			}
		}
		
		return unionCnt != N * N;
	}

	private static void makeUnion(int R, int C) {
		int size = 0;
		int total = 0;
		Queue<Pos> curUnion = new LinkedList<>();

		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(R, C, map[R][C]));
		while (!q.isEmpty()) {
			Pos cur = q.poll();

			int r = cur.r;
			int c = cur.c;
			int people = cur.people;

			if (visited[r][c])
				continue;
			visited[r][c] = true;

			size++;
			total += people;
			curUnion.add(cur);

			for (int[] dir : dirs) {
				int nr = r + dir[0];
				int nc = c + dir[1];

				if (isOut(nr, nc))
					continue;

				if (checkDiff(people, map[nr][nc])) {
					q.add(new Pos(nr, nc, map[nr][nc]));
				}
			}
		}

		int afterMove = total / size;
		while (!curUnion.isEmpty()) {
			Pos cur = curUnion.poll();
			cur.people = afterMove;
			unions.add(cur);
		}
	}

	private static boolean isOut(int nr, int nc) {
		return nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1;
	}

	private static boolean checkDiff(int my, int other) {
		int diff = Math.abs(my - other);
		return diff >= L && diff <= R;
	}

	private static void move() {
		while (!unions.isEmpty()) {
			Pos cur = unions.poll();
			map[cur.r][cur.c] = cur.people;
		}
	}
}