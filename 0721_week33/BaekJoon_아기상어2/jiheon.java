package 구현;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086_아기상어2 {

	static int N,M,map[][],dist[][],max=Integer.MIN_VALUE,dir[][]= {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	static Queue<Point> q=new LinkedList<>();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		dist=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					q.add(new Point(i,j));
				}
			}
		}
		
		bfs();
		System.out.println(max);
		
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		while(!q.isEmpty()) {
			Point p=q.poll();
			
			for(int d=0;d<dir.length;d++) {
				int nr=p.x+dir[d][0];
				int nc=p.y+dir[d][1];
				
				if(nr<0||nc<0||nr>=N||nc>=M||map[nr][nc]==1||dist[nr][nc]!=0)
					continue;
				else {
					dist[nr][nc]=dist[p.x][p.y]+1;
					max=Math.max(dist[nr][nc], max);
					q.add(new Point(nr,nc));
				}
			}
		}
	}

}
