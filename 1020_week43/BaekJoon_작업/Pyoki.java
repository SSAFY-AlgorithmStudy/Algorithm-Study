import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	

	static int N;
	static ArrayList<ArrayList<Integer>> adjList;
	static int[] times;
	static int[] finishTime;
	static int[] inDegreeArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		adjList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
		}
		times = new int[N + 1];
		inDegreeArr = new int[N + 1];
		finishTime = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		int firstJobTime = Integer.parseInt(st.nextToken());
		times[1] = firstJobTime;

		for (int i = 2; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int preJobCnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < preJobCnt; j++) {
				int preJob = Integer.parseInt(st.nextToken());
				adjList.get(preJob).add(i);
				inDegreeArr[i]++;
			}
			times[i] = time;
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
				finishTime[i] = times[i];
				if(inDegreeArr[i]==0)q.add(i);		 
		}
		
		while (!q.isEmpty()) {
			int job = q.poll();
			ArrayList<Integer> tempList = adjList.get(job);
			for (int nextJob : tempList) {
				inDegreeArr[nextJob]--;
				finishTime[nextJob] =Math.max(finishTime[nextJob], finishTime[job] + times[nextJob]);
				if(inDegreeArr[nextJob]==0)q.add(nextJob);

			}

		}
		int answer = Integer.MIN_VALUE;
		for (int k : finishTime) {
			answer = Math.max(k, answer);
		}

		System.out.println(answer);

	}
}
