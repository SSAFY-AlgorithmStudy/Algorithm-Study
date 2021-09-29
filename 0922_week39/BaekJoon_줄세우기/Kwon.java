import java.util.*;
import java.io.*;

public class Kwon {

	static int N, M;
	static int[] degrees;
	static ArrayList<Integer>[] order;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		degrees = new int[N + 1];
		order = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			order[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());

			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());

			order[front].add(back);
			degrees[back]++;
		}

		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (degrees[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();

			sb.append(cur).append(' ');

			for (int next : order[cur]) {
				if (--degrees[next] == 0) {
					q.add(next);
				}
			}
		}

		System.out.println(sb);
	}
}