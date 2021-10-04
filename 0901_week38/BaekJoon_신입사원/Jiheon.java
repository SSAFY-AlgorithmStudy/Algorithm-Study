package GREEDY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1946_신입사원2 {

	static int T,N,score[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T=Integer.parseInt(bf.readLine());
		for(int tc=0;tc<T;tc++) {
			int cnt=1;
			N=Integer.parseInt(bf.readLine());
			score=new int[N+1];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(bf.readLine());
				score[Integer.parseInt(st.nextToken())]=Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(score));
			int tmp=score[1];
			
			for(int i=2;i<=N;i++) {
				if(tmp>score[i]) {
					cnt++;
					tmp=score[i];
				}
			}
			System.out.println(cnt);
		}
	}
}
