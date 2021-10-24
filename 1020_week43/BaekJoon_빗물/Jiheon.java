package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {

	static int H,W;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		
		int map[]=new int[W];
		st=new StringTokenizer(bf.readLine());
		
		for(int i=0;i<W;i++) {
			int num=Integer.parseInt(st.nextToken());
			map[i]=num;
		}
		int sum=0;
		for(int i=1;i<W-1;i++) {
			int left=0,right=0;
			for(int j=i-1;j>=0;j--) {
				left=Math.max(map[j], left);
			}
			for(int j=i;j<W;j++) {
				right=Math.max(map[j], right);
			}
			
			if(left>map[i]&&right>map[i]) {
				int height=Math.min(left, right);
				sum+=(height-map[i]);
			}
		}



		System.out.println(sum);
	}

}
