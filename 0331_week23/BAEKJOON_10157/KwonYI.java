package baekjoon;

import java.io.*;
import java.util.*;

public class BAEK_10157 {

	static int C, R, K;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		K = Integer.valueOf(bf.readLine());

		if (K > R * C) {
			System.out.println(0);
			return;
		}

		int cnt = 0;
		int maxR = R;
		int maxC = C;
		int nr = R;
		int nc = 0;

		ex: while (cnt != K) {
			for (int i = 0; i < maxR; i++) {
				nr--;
				if (++cnt == K) {
					break ex;
				}
			}
			maxC--;
			for (int i = 0; i < maxC; i++) {
				nc++;
				if (++cnt == K) {
					break ex;
				}
			}
			maxR--;
			for (int i = 0; i < maxR; i++) {
				nr++;
				if (++cnt == K) {
					break ex;
				}
			}
			maxC--;
			for (int i = 0; i < maxC; i++) {
				nc--;
				if (++cnt == K) {
					break ex;
				}
			}
			maxR--;
		}
		// ÁÂÇ¥ º¯È¯ (nr, nc) -> (nc + 1, R - nr)
		System.out.println((nc + 1) + " " + (R - nr));
	}
}