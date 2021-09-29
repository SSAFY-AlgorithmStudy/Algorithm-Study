import java.io.*;
import java.util.*;

public class Main {

	static class Ball {
		int r;
		int c;
		int m;
		int s;
		int d;

		public Ball(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	static int N, M, K;
	static Queue<Ball> fireBalls = new LinkedList<Ball>();
	static int[][] dirs = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());

			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			fireBalls.add(new Ball(r, c, m, s, d));
		}

		for (int k = 0; k < K; k++) {
			HashMap<Integer, ArrayList<Ball>> afterMove = new HashMap<>();

			while (!fireBalls.isEmpty()) {
				Ball cur = fireBalls.poll();

				int r = cur.r;
				int c = cur.c;
				int m = cur.m;
				int s = cur.s;
				int d = cur.d;
				int afterPos = move(r, c, d, s % N);

				if (!afterMove.containsKey(afterPos))
					afterMove.put(afterPos, new ArrayList<>());

				r = afterPos / N;
				c = afterPos % N;

				afterMove.get(afterPos).add(new Ball(r, c, m, s, d));
			}

			for (int afterPos : afterMove.keySet()) {
				ArrayList<Ball> balls = afterMove.get(afterPos);

				if (balls.size() >= 2) {
					int totalM = 0;
					int totalS = 0;
					int r = afterPos / N;
					int c = afterPos % N;

					boolean checking = false;
					boolean isEven = false;
					boolean allSame = true;

					for (Ball ball : balls) {
						totalM += ball.m;
						totalS += ball.s;

						if (!checking) {
							if (ball.d % 2 == 0)
								isEven = true;
							checking = true;
						} else {
							boolean dir = ball.d % 2 == 0;

							if (dir ^ isEven) {
								allSame = false;
							}
						}
					}

					int afterM = totalM / 5;
					if (afterM != 0) {
						int afterS = totalS / balls.size();
						int startD = 0;

						if (allSame)
							startD = 0;
						else
							startD = 1;

						for (int d = startD; d < 8; d += 2) {
							fireBalls.add(new Ball(r, c, afterM, afterS, d));
						}
					}
				} else {
					fireBalls.add(balls.get(0));
				}
			}
		}

		int answer = 0;
		while (!fireBalls.isEmpty()) {
			answer += fireBalls.poll().m;
		}

		System.out.println(answer);
	}

	private static int move(int r, int c, int d, int s) {
		for (int i = 0; i < s; i++) {
			r += dirs[d][0];
			c += dirs[d][1];

			if (r == -1)
				r = N - 1;
			else if (r == N)
				r = 0;

			if (c == -1)
				c = N - 1;
			else if (c == N)
				c = 0;
		}

		return r * N + c;
	}
}