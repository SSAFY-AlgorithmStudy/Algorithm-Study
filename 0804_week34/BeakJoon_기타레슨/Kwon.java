import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int min, max;
	static int[] videos;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		videos = new int[N];
		min = 1;
		max = 0;

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			videos[i] = Integer.parseInt(st.nextToken());
			max += videos[i];
		}

		while (min < max) {
			int mid = (min + max) / 2;
			int cnt = makeBluelay(mid);
			
			if (cnt > M) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}

		System.out.println(max);
	}

	private static int makeBluelay(int length) {
		int cnt = 1;
		int total = 0;

		for (int i = 0; i < N; i++) {
			// 현재 길이로는 블루레이를 만들 수 없다
			if (videos[i] > length) return Integer.MAX_VALUE;

			// 영상 길이를 초과한다
			if (total + videos[i] > length) {
				cnt++;
				total = videos[i];
			} else {
				total += videos[i];
			}
		}

		return cnt;
	}
}