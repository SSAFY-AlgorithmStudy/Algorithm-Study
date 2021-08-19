import java.io.*;
import java.util.*;

public class Main {

	static class Road {
		int from;
		int to;
		int price;

		public Road(int f, int t, int p) {
			this.from = f;
			this.to = t;
			this.price = p;
		}
	}

	static int N, M;
	static int[] p;
	static PriorityQueue<Road> roads;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
        
		p = new int[N + 1];
		roads = new PriorityQueue<>((o1, o2) -> o1.price - o2.price);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());

			roads.add(new Road(from, to, price));
		}

		init();
		int total = 0;
		int cnt = 0;
		while (!roads.isEmpty()) {
			Road road = roads.poll();

			int from = road.from;
			int to = road.to;
			int price = road.price;

			if (union(from, to)) {
				total += price;
				if (++cnt == N - 2)
					break;
			}
		}

		System.out.println(total);
	}

	public static void init() {
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
	}

	public static int find(int x) {
		if (x != p[x])
			p[x] = find(p[x]);
		return p[x];
	}

	public static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);

		if (px == py)
			return false;

		p[py] = px;
		return true;
	}
}