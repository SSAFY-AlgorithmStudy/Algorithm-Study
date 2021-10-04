package 구현;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_4153_직각삼각형 {

	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int a,b,c;
		while(true) {
			String line=sc.nextLine();
			StringTokenizer st=new StringTokenizer(line);
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			
			if(a==0&&b==0&&c==0)
				break;
			
			int len[]= {a,b,c};
			Arrays.sort(len);
			
			len[0]=(int)Math.pow(len[0],2);
			len[1]=(int)Math.pow(len[1],2);
			len[2]=(int)Math.pow(len[2],2);
			
			if(len[2]==len[0]+len[1]) {
				System.out.println("right");				
			}else {
				System.out.println("wrong");
			}
		}
		
		
	}
}
