import java.io.*;
import java.util.*;

public class Kwon {

	static int T, N;
	static int[] interviews;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.valueOf(bf.readLine());

		for (int testCase = 0; testCase < T; testCase++) {
			N = Integer.valueOf(bf.readLine());
			interviews = new int[N + 1];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());

				int resume = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());

				interviews[resume] = interview;
			}
			
			int answer = 1;
			int curGrade = interviews[1];
			for(int i = 2; i <= N; i++) {
				if(interviews[i] < curGrade) {
					answer++;
					curGrade = interviews[i];
				}
			}

			sb.append(answer).append('\n');
		}

		System.out.println(sb);
	}
}