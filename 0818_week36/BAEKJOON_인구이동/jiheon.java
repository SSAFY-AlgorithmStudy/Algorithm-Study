package 구현;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동2 {

	static int N,R,L,map[][],day,dir[][]= {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean visited[][],flag;
	static Queue<Point> q;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			visited=new boolean[N][N];
			flag=false;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j]&&check(i,j)) {
						bfs(i,j);
						flag=true;
						
					}
				}
			}
			if(!flag)
				break;
			else
				day++;
		}

		System.out.println(day);
	}
	private static void bfs(int i, int j) {
		// TODO Auto-generated method stub
		q=new LinkedList<>();
		q.add(new Point(i,j));
		visited[i][j]=true;
		ArrayList<Point> list=new ArrayList<>();
		int sum=0;
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			list.add(p);
			int r=p.x;
			int c=p.y;
			int num=map[r][c];
			sum+=num;

			for(int d=0;d<4;d++) {
				int nr=r+dir[d][0];
				int nc=c+dir[d][1];
				
				if(nr<0||nc<0||nr>=N||nc>=N||visited[nr][nc])
					continue;
				
				else if(Math.abs(num-map[nr][nc])>=L&&Math.abs(num-map[nr][nc])<=R) {
					visited[nr][nc]=true;
					q.add(new Point(nr,nc));
				}
			}
		}
		
		int val=sum/list.size();
		
		for(int p=0;p<list.size();p++) {
			Point c=list.get(p);
			map[c.x][c.y]=val;
		}
		
		
	}
	private static boolean check(int i, int j) {
		int num=map[i][j];
		for(int d=0;d<4;d++) {
			int nr=i+dir[d][0];
			int nc=j+dir[d][1];
			
			if(nr>=0&&nc>=0&&nr<N&&nc<N&&Math.abs(num-map[nr][nc])>=L&&Math.abs(num-map[nr][nc])<=R)
				return true;
		}
		return false;
	}

}
