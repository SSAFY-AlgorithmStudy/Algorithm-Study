import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pyoki {
	
		static int R,C,K;
		static int [][] map;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C =Integer.parseInt(st.nextToken());
		R= Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int min = Math.min(C, R);
		
		if(K>R*C)System.out.println(0);
		else{
			fill(0,0,R,C,1,min);
		}
//		for(int i=0;i<R;i++) {
//			for(int j=0;j<C;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		
	}
		static void fill(int startR ,int startC,int lenR,int lenC,int num,int min) {
			if(min<=0)return;
			
			for(int i=0;i<lenR;i++) {
				map[startR+i][startC] =num;
				if(num==K) {
					System.out.println((startC+1)+" "+(startR+i+1));
					return;
				}
				num++;
			}
			num--;
			for(int i=0;i<lenC;i++) {
				map[startR+lenR-1][startC+i]=num;
				if(num==K) {
					System.out.println((startC+i+1)+" "+(startR+lenR-1+1));
					return;
				}
				num++;
			}
			num--;
			for(int i=0;i<lenR;i++) {
				map[startR+(lenR-1)-i][startC+lenC-1]=num;
				if(num==K) {
					System.out.println((startC+lenC-1+1)+" "+(startR+(lenR-1)-i+1));
					return;
				}
				num++;
               
			}
			num--;
			for(int i=0;i<lenC-1;i++) {
				map[startR][startC+(lenC-1)-i]=num;
				if(num==K) {
					System.out.println((startC+(lenC-1)-i+1)+" "+(startR+1));
					return;
				}    
				num++;
			}
			 fill(startR+1,startC+1,lenR-2,lenC-2,num,min-2);
		}
}
