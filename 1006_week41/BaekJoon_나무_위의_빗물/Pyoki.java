import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	 static ArrayList<ArrayList<Integer>> adjList;
	 static boolean [] visited;
	 static int reafNodeCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			adjList.get(U).add(V);
			adjList.get(V).add(U);
		}
		visited = new boolean[N+1];
		reafNodeCnt =0;
		visited[1]=true;
		dfs(1);
		
		double answer = (double)W/(double)reafNodeCnt;
		System.out.println(answer);
		
	}
	static void dfs(int start) {
	
		ArrayList<Integer> nextNode = adjList.get(start);
		boolean childCheck = false;
		for(int next : nextNode) {
			if(!visited[next]) {
				visited[next]=true;
				dfs(next);
				childCheck= true;
			}
		}
		if(!childCheck) reafNodeCnt++;
	}

}

