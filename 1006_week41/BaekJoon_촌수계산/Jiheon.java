package TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {

	static int N,A,B,M,ans=-1;
	static boolean visited[];
	static ArrayList<Integer> tree[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N=Integer.parseInt(bf.readLine());
		st=new StringTokenizer(bf.readLine());
		
		A=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		
		M=Integer.parseInt(bf.readLine());
		
		tree=new ArrayList[N+1];
		visited=new boolean[N+1];
		
		for(int i=1;i<=N;i++) {
			tree[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(bf.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			tree[a].add(b);
			tree[b].add(a);
		}
		
		find(0,A);
		
		System.out.println(ans);
	}
	private static void find(int cnt,int num) {
		// TODO Auto-generated method stub
		if(num==B) {
			ans=cnt;
			return;
		}
		visited[num]=true;
		
		for(int i=0;i<tree[num].size();i++) {
			int next=tree[num].get(i);
			if(!visited[next])
				find(cnt+1,next);
		}
	}

}
