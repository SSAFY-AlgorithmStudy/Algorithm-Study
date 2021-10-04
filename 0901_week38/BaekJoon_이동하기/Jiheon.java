package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11048_이동하기 {

	static int N,M,dp[][],input[][],dir[][]= {{1,0},{0,1},{1,1}};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		dp=new int[N][M];
		input=new int[N][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				input[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				for(int d=0;d<3;d++) {
					int nr=i+dir[d][0];
					int nc=j+dir[d][1];
					
					if(nr<0||nc<0||nr>=N||nc>=M)
						continue;
					dp[nr][nc]=Math.max(dp[nr][nc],dp[i][j]+input[nr][nc]);
				}
				
//				for(int k=0;k<N;k++) {
//					for(int p=0;p<M;p++) {
//						System.out.print(dp[k][p]+" ");
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
		}
		
		System.out.println(dp[N-1][M-1]+input[0][0]);
	}

}
