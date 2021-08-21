package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343_기타레슨 {

	static int N,M,lesson[],min=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		lesson=new int[N];
		int left=-1,right=0;
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			lesson[i]=Integer.parseInt(st.nextToken());
			left=Math.max(left, lesson[i]);
			right+=lesson[i];
		}
		
		while(left<=right) {
			int mid=(left+right)/2;
			
			int sum=0;
			int count=1;
			for(int i=0;i<N;i++) {
				if(sum+lesson[i]<=mid) {
					sum+=lesson[i];					
				}else {
					sum=lesson[i];
					count++;
				}
			}
			
			if(count<=M) {
				min=Math.min(mid, min);
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		System.out.println(min);
	}

}
