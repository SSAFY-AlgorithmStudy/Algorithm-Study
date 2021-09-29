import java.io.*;
import java.util.*;

public class Kwon {

	static int N;
	static int[][] roads;
	static boolean flag;
	static boolean[] visited;
	static final String SUCCESS = "happy";
	static final String FAIL = "sad";

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.valueOf(bf.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			N = Integer.valueOf(bf.readLine());
			roads = new int[N + 2][2];
			for (int i = 0; i < N + 2; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				roads[i][0] = x;
				roads[i][1] = y;
			}

			flag = false;
			visited = new boolean[N + 2];
			Queue<Integer> q = new LinkedList<>();
			q.add(0);
			while (!q.isEmpty()) {
				int cur = q.poll();

				if (cur == N + 1) {
					flag = true;
					break;
				}

				if (visited[cur])
					continue;
				visited[cur] = true;

				int x = roads[cur][0];
				int y = roads[cur][1];

				for (int i = 1; i < N + 2; i++) {
					int nextX = roads[i][0];
					int nextY = roads[i][1];

					if (Math.abs(x - nextX) + Math.abs(y - nextY) <= 1000) {
						q.add(i);
					}
				}
			}

			if (flag)
				sb.append(SUCCESS).append('\n');
			else
				sb.append(FAIL).append('\n');
		}

		System.out.println(sb);
	}
}