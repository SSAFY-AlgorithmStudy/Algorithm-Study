package BruteForce;

import java.util.Scanner;

public class BOJ_1681_줄세우기 {
	static int N,L,cnt=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		L=sc.nextInt();
		String l=Integer.toString(L);
		int i=1;
		String str;
		
		while(true) {
			if(cnt==N)
				break;
			str=Integer.toString(i);
			if(str.contains(l)) {
				i++;
			}else {
				cnt++;
				i++;
			}
		}
		System.out.println(i-1);
		sc.close();
	}

}
