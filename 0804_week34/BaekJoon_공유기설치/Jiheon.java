package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110_공유기설치 {

	static int N,C,point[],maxLen=Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		point=new int[N];
		for(int i=0;i<N;i++) {
			point[i]=Integer.parseInt(bf.readLine());
		}
		Arrays.sort(point);
		
		//최소 간격
		int left=1;
		//전체 간격
		int right=point[N-1]-point[0];
		
		while(left<=right) {
			int mid=(left+right)/2;
			int count=1;
			int prev=point[0];
			
			for(int i=1;i<N;i++) {
				if(prev+mid<=point[i]) {
					count++;
					prev=point[i];
				}
			}
			if(count>=C) {
				maxLen=Math.max(mid, maxLen);
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		System.out.println(maxLen);
	}

}
