package BFS_DFS;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2589_보물섬 {

	static int R,C,map[][],time=0,dist[][],dir[][]= {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean visited[][];
	static Point start;
	static Queue<int[]> q;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String size[]=bf.readLine().split(" ");
		R=Integer.parseInt(size[0]);
		C=Integer.parseInt(size[1]);
		
		map=new int[R][C];
		for(int i=0;i<R;i++) {
			String str=bf.readLine();
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='L') {
					map[i][j]=1;
				}else {
					map[i][j]=0;
				}
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]==1) {
					start=new Point(i,j);
					dist=new int[R][C];
					int cnt=bfs(start);
					time=Math.max(cnt, time);
				}
			}
		}
		
		System.out.println(time);
		
	}
	private static int bfs(Point start) {
		// TODO Auto-generated method stub
		q=new LinkedList<>();
		visited=new boolean[R][C];
		dist=new int[R][C];
		visited[start.x][start.y]=true;
		dist[start.x][start.y]=0;
		q.add(new int[] {start.x,start.y});
		
		while(!q.isEmpty()) {
			int[] tmp=q.poll();
			
			for(int i=0;i<4;i++) {
				int nr=tmp[0]+dir[i][0];
				int nc=tmp[1]+dir[i][1];
				
				if(nr<0||nc<0||nr>=R||nc>=C||visited[nr][nc]||map[nr][nc]==0)
					continue;
				else {
					q.add(new int[] {nr,nc});
					visited[nr][nc]=true;
					dist[nr][nc]=dist[tmp[0]][tmp[1]]+1;
				}
			}
		}
		
		int cnt=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(dist[i][j]!=0) {
					cnt=Math.max(cnt, dist[i][j]);
				}
			}
		}
		return cnt;
	}

}
