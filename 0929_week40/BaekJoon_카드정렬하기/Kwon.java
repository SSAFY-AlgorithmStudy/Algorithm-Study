import java.io.*;
import java.util.*;

public class Kwon {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.valueOf(bf.readLine());
		for (int i = 0; i < N; i++) {
			int cur = Integer.valueOf(bf.readLine());
			pq.add(cur);
		}

		int answer = 0;
		if(N > 1) {
			while (pq.size() > 2) {
				int next = pq.poll() + pq.poll();
				answer += next;
				pq.add(next);
			}

			while (!pq.isEmpty()) {
				answer += pq.poll();
			}
		}
		
		System.out.println(answer);
	}
}