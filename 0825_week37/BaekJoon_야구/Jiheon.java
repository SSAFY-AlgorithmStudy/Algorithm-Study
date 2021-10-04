package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17281_야구 {

	static int batting[],num=0, N,max = Integer.MIN_VALUE, score[][];
	static boolean selected[];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(bf.readLine());

		score = new int[N + 1][10];
		batting = new int[10];
		selected = new boolean[10];

		batting[4] = 1;
		selected[4] = true;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= 9; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		permutation(2);
		System.out.println(max);
	}

	private static void permutation(int cnt) {
		// TODO Auto-generated method stub
		if (cnt == 10) {
//			System.out.println(Arrays.toString(batting));
			play(batting);
			return;
		}

		for (int i = 1; i < 10; i++) {
			if (selected[i])
				continue;
			selected[i] = true;
			batting[i] = cnt;
			permutation(cnt + 1);
			selected[i] = false;
		}
	}

	private static void play(int[] bat) {
		// TODO Auto-generated method stub
		int inning = 1, res = 0, start = 1;
		while (inning <= N) {
			boolean[] base = new boolean[4];
			int out = 0;
			
			while (out < 3) {
				int hit = score[inning][bat[start]];
//				System.out.println(start+" "+inning);
				start++;
				start %= 10;
				if(start==0)
					start=1;
				
				switch (hit) {
				case 0:
					out++;
					break;
				case 1:
					for(int i=3;i>=1;i--) {
						if(base[i]) {
							if(i==3) {
								res++;
								base[i]=false;
								continue;
	
							}							
							base[i+1]=true;
							base[i]=false;
						}
					}
					base[1]=true;
					break;
				case 2:
					for(int i=3;i>=1;i--) {
						if(base[i]) {
							if(i==3||i==2) {
								res++;
								base[i]=false;
								continue;
							}
							base[i+2]=true;
							base[i]=false;	
						}
					}
					base[2]=true;
					break;
				case 3:
					for(int i=3;i>=1;i--) {
						if(base[i]) {
							res++;
							base[i]=false;
						}
					}
					base[3]=true;
					break;
				case 4:
					for (int i = 1; i <= 3; i++) {
						if (base[i]) {
							res++;
							base[i] = false;
						}
					}
					// 본인 점수
					res++;
					break;
				}
			}
			
			inning++;
		}
		max=Math.max(max,res);

	}

}
