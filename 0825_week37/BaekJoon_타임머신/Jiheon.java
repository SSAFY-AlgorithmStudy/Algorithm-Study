package ShortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657_타임머신 {

	static int N,M;
	static long dist[];
	static final int INF=10000*1000;
	static ArrayList<int[]> graph[];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		graph=new ArrayList[N+1];
		dist=new long[N+1];
		
		for(int i=1;i<=N;i++) {
			graph[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[from].add(new int[] {to,weight});
		}
		
		if(!bellmanFord()) {
			System.out.println("-1");
		}else {
			for(int i=2;i<=N;i++) {
				if(dist[i]==INF)
					System.out.println("-1");
				else
					System.out.println(dist[i]);
			}
		}
	}
	private static boolean bellmanFord() {
		// TODO Auto-generated method stub
		Arrays.fill(dist,INF);
		dist[1]=0;

		//모든 정점에 대해 n-1번 수행
		for(int i=0;i<N-1;i++) {
			for(int j=1;j<=N;j++) {
				for(int[] tmp:graph[j]) {
					if(dist[j]!=INF&&dist[tmp[0]]>dist[j]+tmp[1]) {
						dist[tmp[0]]=dist[j]+tmp[1];
//						System.out.println(Arrays.toString(dist)+" "+j);
					}
				}
			}
		}
//		N^3
		for(int i=1;i<=N;i++) {
			for(int[] tmp:graph[i]) {
				if(dist[i]!=INF&&dist[tmp[0]]>dist[i]+tmp[1]) {
					return false;
				}
			}
		}
		return true;
	}
}
//	dist[j]!=INF
//	4 3
//	1 2 3
//	3 4 -2
//	4 3 -1
