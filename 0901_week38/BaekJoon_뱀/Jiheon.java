package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.awt.Point;

public class BOJ_3190_뱀 {

	static char direction[]=new char[10000];
	static int map[][],N,K,L,time,dir[][]= {{0,1},{1,0},{0,-1},{-1,0}};
	static Deque<Point> snake=new LinkedList<>();
	public static void main(String args[]) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		map=new int[N][N];
		
		K=Integer.parseInt(bf.readLine());
		for(int i=0;i<K;i++) {
			StringTokenizer st=new StringTokenizer(bf.readLine());
			int r=Integer.parseInt(st.nextToken())-1;
			int c=Integer.parseInt(st.nextToken())-1;
			map[r][c]=1;
		}
		
		Arrays.fill(direction, 'A');
		L=Integer.parseInt(bf.readLine());
		for(int i=0;i<L;i++) {
			StringTokenizer st=new StringTokenizer(bf.readLine());
			int r=Integer.parseInt(st.nextToken());
			char c=st.nextToken().charAt(0);
			direction[r]=c;
		}
		
		//뱀의 크기=size
		snake.offer(new Point(0,0));
		map[0][0]=2;
		
		//현재 대가리 방향
		int curD=0;
		while(true) {
			Point head=snake.peekFirst();
			if(direction[time]!='A') {
				if(direction[time]=='L') {
					curD--;
					if(curD<0)
						curD=3;
				}
				if(direction[time]=='D') {
					curD++;
					curD%=4;
				}
			}
			
			int nr=head.x+dir[curD][0];
			int nc=head.y+dir[curD][1];				

			if(nr<0||nc<0||nr>=N||nc>=N||map[nr][nc]==2) {
				time++;
				break;
			}
			snake.offerFirst(new Point(nr,nc));
			
			//사과가 없다면
			if(map[nr][nc]!=1){
				Point tmp=snake.pollLast();
				map[tmp.x][tmp.y]=0;
			}
			
			map[nr][nc]=2;
			time++;
		}
		System.out.println(time);
	}
}
