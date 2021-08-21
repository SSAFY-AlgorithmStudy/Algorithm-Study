package GRAPH;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할계획 {

	static int parent[],N,M;
	static PriorityQueue<house> pq;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		pq=new PriorityQueue<>();
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		parent=new int[N+1];
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(bf.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			pq.add(new house(start,end,weight));
		}
		
		for(int i=1;i<=N;i++) {
			parent[i]=i;
		}
		
		int count=0;
		int minDist=0;
		
		while(count<N-2) {
			house h=pq.poll();
			int a=find(h.start);
			int b=find(h.end);
			
			if(a!=b) {
				union(a,b);
				minDist+=h.weight;
				count++;
			}
		}
		System.out.println(minDist);
		
	}
	static int find(int a) {
		if(parent[a]==a)
			return a;
		return parent[a]=find(parent[a]);
	}
	static void union(int a,int b) {
		a=find(a);
		b=find(b);
		
		parent[a]=b;
	}

}
class house implements Comparable<house>{
	int start;
	int end;
	int weight;
	
	public house(int start,int end,int weight) {
		this.start=start;
		this.end=end;
		this.weight=weight;
	}

	@Override
	public int compareTo(house o) {
		// TODO Auto-generated method stub
		return this.weight-o.weight;
	}
}
