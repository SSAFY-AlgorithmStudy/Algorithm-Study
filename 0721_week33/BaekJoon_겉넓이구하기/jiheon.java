package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16931_겉넓이구하기 {

	static int map[][],N,M;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N+1][M+1];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int sum=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int right=map[i][j]-map[i][j+1];
				int left=map[i][j]-map[i+1][j];
				
				if(right>0)
					sum+=right;
				if(left>0)
					sum+=left;
			}
		}
		sum+=N*M;
		sum*=2;
		System.out.println(sum);
	}

}
