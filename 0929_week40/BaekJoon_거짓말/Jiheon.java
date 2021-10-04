package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1043_거짓말 {

	static int N,M,truth[],parent[],cnt=0;
	static ArrayList<int[]> party=new ArrayList<>();
	public static void main(String args[]) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		parent=new int[N+1];
		make();
		st=new StringTokenizer(bf.readLine());
		int size=Integer.parseInt(st.nextToken());
		if(size!=0) {
			truth=new int[size];
			for(int i=0;i<size;i++) {
				truth[i]=Integer.parseInt(st.nextToken());
			}
		}else {
			System.out.println(M);
			System.exit(0);
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(bf.readLine());
			size=Integer.parseInt(st.nextToken());
			
			int[] tmp=new int[size];
			tmp[0]=Integer.parseInt(st.nextToken());
			for(int j=1;j<size;j++) {
				int num=Integer.parseInt(st.nextToken());
				tmp[j]=num;
				union(tmp[0],num);
			}
			party.add(tmp);
		}
		
		for(int[] tmp:party) {
			boolean flag=false;
			for(int i=0;i<tmp.length;i++) {
				int x=find(tmp[i]);
				for(int j=0;j<truth.length;j++) {
					if(x==find(truth[j])) {
						flag=true;
						break;
					}
				}
				if(flag)
					break;
			}
			
			if(!flag)
				cnt++;
		}
		System.out.println(cnt);
		
	}
	
	private static void make() {
		for(int i=0;i<=N;i++) {
			parent[i]=i;
		}
	}
	
	private static int find(int x) {
		if(x==parent[x])
			return x;
		return parent[x]=find(parent[x]);
	}
	
	private static void union(int x,int y) {
		x=find(x);
		y=find(y);
		
		if(x<y) {
			parent[y]=x;
		}else
			parent[x]=y;
	}
	
}
