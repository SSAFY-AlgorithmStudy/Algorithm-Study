package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16927_배열돌리기2 {

	static int map[][],N,M,R,dir[][]= {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		int line=Math.min(N, M);
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int l=0;l<line/2;l++) {
			int lotate=2*(N-2*l+M-2*l-4)+4;
			//실제 이동
			int move=R%lotate;

			int count=0;
			while(count<move) {
				int start=map[l][l];
				
				int r=l;
				int c=l;
				int d=0;
				
				while(d<4) {
					int nr=r+dir[d][0];
					int nc=c+dir[d][1];
					
					if(nr==r&&nc==c)
						break;
					if(nr<N-l&&nc<M-l&&nr>=l&&nc>=l) {
						map[r][c]=map[nr][nc];
						r=nr;
						c=nc;
					}else {
						d++;
					}
				}
				map[l+1][l]=start;
				count++;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
