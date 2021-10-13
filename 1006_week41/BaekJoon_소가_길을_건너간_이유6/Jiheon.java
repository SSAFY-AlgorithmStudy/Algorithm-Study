package BFS_DFS;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14466_소가길을6 {

	static int N, K, R, ans = 0,dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean visited[][];
	static Point cows[];
	static Queue<Point> q;	
	static ArrayList<Point> road[][];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		cows = new Point[K];
		road=new ArrayList[N+1][N+1];
		
		for(int i=0;i<=N;i++) {
			for(int j=0;j<=N;j++) {
				road[i][j]=new ArrayList<>();
			}
		}

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int mr = Integer.parseInt(st.nextToken());
			int mc = Integer.parseInt(st.nextToken());

			road[r][c].add(new Point(mr,mc));
			road[mr][mc].add(new Point(r,c));
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine());
			cows[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for(int i=0;i<K;i++) {
			Point start=cows[i];
			visited = new boolean[N+1][N+1];
			bfs(start);
			for(int j=i+1;j<K;j++) {
				Point dest=cows[j];
				if(!visited[dest.x][dest.y])
					ans++;
				
			}
		}
		System.out.println(ans);

	}

	private static void bfs(Point start) {
		// TODO Auto-generated method stub
		q = new LinkedList<>();
		q.add(start);
		visited[start.x][start.y] = true;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.x + dir[d][0];
				int nc = p.y + dir[d][1];
				
				if(nr<=0||nc<=0||nr>N||nc>N||visited[nr][nc])
					continue;
				if(road[p.x][p.y].contains(new Point(nr,nc)))
					continue;
				
				q.add(new Point(nr,nc));
				visited[nr][nc]=true;
			}
		}
	}

}
