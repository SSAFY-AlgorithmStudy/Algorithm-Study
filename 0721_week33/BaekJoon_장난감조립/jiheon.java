package GRAPH;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2637_장난감조립 {

	static int N,M,result[],indegree[];
	static boolean isBasic[];
	static ArrayList<int[]> list[];
	static Queue<Integer> q=new LinkedList<>();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		M=Integer.parseInt(bf.readLine());
		
		indegree=new int[N+1];
		isBasic=new boolean[N+1];
		result=new int[N+1];
		list=new ArrayList[N+1];
		
		Arrays.fill(isBasic, true);
		for(int i=0;i<=N;i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			StringTokenizer st=new StringTokenizer(bf.readLine());
			int X=Integer.parseInt(st.nextToken());
			int Y=Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			
			list[X].add(new int[] {Y,K});
			isBasic[X]=false;
			indegree[Y]++;
		}
		//완성부품 = N
		q.add(N);
		result[N]=1;
		while(!q.isEmpty()) {
			int num=q.poll();
			int cnt=result[num];
			System.out.println(num+" "+Arrays.toString(result));
			
			for(int i=0;i<list[num].size();i++) {
				int node=list[num].get(i)[0];
				int K=list[num].get(i)[1];
				indegree[node]--;
				result[node]+=(K*cnt);					
				if(indegree[node]==0) {
					q.add(node);
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			if(isBasic[i]) {
				System.out.println(i+" "+result[i]);
			}
		}
		
	}
	

}
