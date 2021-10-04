package GRAPH;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기 {

	static int tc,n;
	static ArrayList<Point> list;
	static boolean isMove[][];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc=Integer.parseInt(bf.readLine());
		for(int t=0;t<tc;t++) {
			n=Integer.parseInt(bf.readLine());
			list=new ArrayList<>();
			isMove=new boolean[n+2][n+2];
			
			for(int i=0;i<n+2;i++) {
				st=new StringTokenizer(bf.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				
				list.add(new Point(x,y));
			}
			
			for(int i=0;i<n+2;i++) {
				for(int j=1;j<n+2;j++) {
					if(i==j)
						continue;
					Point t1=list.get(i);
					Point t2=list.get(j);
					
					int distance=Math.abs(t1.x-t2.x)+Math.abs(t1.y-t2.y);
					if(distance<=1000) {
						isMove[i][j]=isMove[j][i]=true;
					}
				}
			}
			
			for(int k=0;k<n+2;k++) {
				for(int i=0;i<n+2;i++) {
					for(int j=0;j<n+2;j++) {
						if(isMove[i][k]&&isMove[k][j]) {
							isMove[i][j]=true;
						}
					}
				}
			}
			
			if(isMove[0][n+1])
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}

}
