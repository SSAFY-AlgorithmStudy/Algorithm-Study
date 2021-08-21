package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_숫자카드 {

	static int N,M,A[],B[],res[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N=Integer.parseInt(bf.readLine());
		A=new int[N];
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		
		M=Integer.parseInt(bf.readLine());
		res=new int[M];
		B=new int[M];
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<M;i++) {
			B[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		for(int i=0;i<M;i++) {
			if(binSearch(i)) {
				res[i]=1;
			}else {
				res[i]=0;
			}
		}
		
		for(int i:res) {
			System.out.print(i+" ");
		}
		
	}
	private static boolean binSearch(int i) {
		int num=B[i];
		int left=0;
		int right=N-1;
		
		while(left<=right) {
			int mid=(left+right)/2;
			
			if(num==A[mid]) {
				return true;
			}else if(num>A[mid]) {
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		return false;
	}

}
