package 이분탐색;

import java.util.Scanner;

public class BOJ_수이어쓰기2_1790 {

	static int N,K;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		
		int left=1;
		int right=N;
		int answer=-1;
		
		while(left<=right) {
			int mid=(left+right)/2;
			int len=getLength(mid);
			
			if(len>K) {
				right=mid-1;
			}else if(len<K){
				left=mid+1;
			}else if(len==K){
				String str=makeNum(mid);
				answer=str.charAt(K-1)-'0';
				break;
			}
			
		}
		System.out.println(answer);
	}
	//1~9 : 9-1+1=9, 10~99:99-10+1=90 자리수:180, 100~999:999-100+1=900 자리수:2700, 1000~9999:9999-1000+1=9000 자리수:3600
	private static String makeNum(int mid) {
		// TODO Auto-generated method stub
		String str="";
		for(int i=1;i<=mid;i++) {
			str+=i;
		}
		return str;
	}
	private static int getLength(int num) {
		int length=0;
		for(int i=1;i<=num;i++) {
			length+=(int)Math.log10(i)+1;
		}
		return length;
	}

}
