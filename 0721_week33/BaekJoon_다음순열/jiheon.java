package 조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10972_다음순열 {

	static int N,input[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		input=new int[N];
		StringTokenizer st=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			input[i]=Integer.parseInt(st.nextToken());
		}

		if(next_permutation()) {
			for(int i=0;i<N;i++) {
				System.out.print(input[i]+" ");
			}
		}else
			System.out.println("-1");
		
		
	}
	private static boolean next_permutation() {
		int i=N-1;
		while(i>0&&input[i-1]>=input[i]) {
			i--;
		}
		if(i==0)
			return false;
		
		int j=N-1;
		while(input[i-1]>=input[j]) {
			j--;
		}
		swap(i-1,j);
		
		int k=N-1;
		while(i<k) {
			swap(i,k);
			i++;
			k--;
		}
		
		return true;
	}
	private static void swap(int i, int j) {
		// TODO Auto-generated method stub
		int tmp=input[j];
		input[j]=input[i];
		input[i]=tmp;
	}
}
