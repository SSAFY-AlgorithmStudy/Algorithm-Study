class Solution {
    static int[][] graph;
	static int INF = 20000000;
	static int MIN;

    public static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = 0;

		graph = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					graph[i][j] = 0;
				else
					graph[i][j] = INF;
			}

		}
		for (int i = 0; i < fares.length; i++) {
			graph[fares[i][0]][fares[i][1]] = fares[i][2];
			graph[fares[i][1]][fares[i][0]] = fares[i][2];
		}

		// 거쳐가는 노드
		for (int k = 1; k <= n; k++) {
			// 출발
			for (int i = 1; i <= n; i++) {
				// 도착
				for (int j = 1; j <= n; j++) {
					if (graph[i][k] + graph[k][j] < graph[i][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];

					}
				}
			}
		}

		MIN = Integer.MAX_VALUE;

		for (int k = 1; k <= n; k++) {
			MIN = Math.min(MIN, graph[s][k] + graph[k][a] + graph[k][b]);
		}

		answer =MIN;
		return answer;
	}
}