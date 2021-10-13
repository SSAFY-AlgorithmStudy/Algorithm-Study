package TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17073_빗물위에빗물 {

	static int N,node[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(st.nextToken());
		double W=Double.parseDouble(st.nextToken());
		double cnt=0;
		
		node=new int[N+1];
		
		for(int i=0;i<N-1;i++) {
			st=new StringTokenizer(bf.readLine());
			int U=Integer.parseInt(st.nextToken());
			int V=Integer.parseInt(st.nextToken());
			
			node[U]++;
			node[V]++;
		}
		
		for(int i=2;i<=N;i++) {
			if(node[i]==1) {
				cnt++;	
			}
		}
		System.out.println(W/cnt);
	}

}
