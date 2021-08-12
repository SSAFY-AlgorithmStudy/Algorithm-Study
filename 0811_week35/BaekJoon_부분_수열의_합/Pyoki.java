import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		arr = new int[N];
		visited = new boolean[20 * 100000];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			visited[arr[i]] = true;
		}

		for (int i = 1; i <= N; i++) {
			int[] pick = new int[i];
			comb(pick, 0, 0, i);
		}
		int answer = 0;
		for (int i = 1; i < visited.length; i++) {
			if (!visited[i]) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);

	}

	static void comb(int[] pick, int start, int depth, int r) {
		if (depth > r - 1) {
			int sum = 0;
			for (int k : pick) {
				sum += arr[k];
			}
			visited[sum] = true;
			return;
		}
		for (int i = start; i < N; i++) {
			pick[depth] = i;
			comb(pick, i + 1, depth + 1, r);
		}
	}
}

