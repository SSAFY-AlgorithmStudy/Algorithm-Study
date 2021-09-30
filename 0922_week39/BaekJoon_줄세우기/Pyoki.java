import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int node;
		int inDegree;
		public Node(int node, int inDegree) {
			this.node=node;
			this.inDegree= inDegree;
		}
	}	
	static int N,M;
	static int []inDegreeArr;
	static boolean []visited;
	static ArrayList<ArrayList<Integer>> adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		adjList = new ArrayList<>();
		
		for(int i=0;i<=N;i++) {
			adjList.add(new ArrayList<>());
		}
		visited = new boolean[N+1];
		inDegreeArr = new int[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());			
			adjList.get(A).add(B);
			inDegreeArr[B]++;
		}
	
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return n1.inDegree-n2.inDegree;
			}			
		});
		
		for(int i=1;i<=N;i++) {
			pq.add(new Node(i,inDegreeArr[i]));
		}
		ArrayList<Integer> answerAl = new ArrayList<>();
		
		while(!pq.isEmpty()) {
			Node n=pq.poll();
			int node =n.node;
			if(!visited[node]) {
				visited[node]=true;
				answerAl.add(node);
				ArrayList<Integer> tempList = adjList.get(node);
				for(int k:tempList) {
					inDegreeArr[k]--;
					pq.add(new Node(k,inDegreeArr[k]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int a:answerAl) {
			sb.append(a).append(' ');
		}
		System.out.print(sb);
	}
}

