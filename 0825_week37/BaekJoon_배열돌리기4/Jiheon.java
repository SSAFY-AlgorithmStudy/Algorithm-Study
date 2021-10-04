package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17406_배열돌리기4 {

	static int N,M,K,perm[],map[][],min=Integer.MAX_VALUE,dir[][]= {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean visited[];
	static ArrayList<int[]> lotate;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		perm=new int[K];
		visited=new boolean[K];
		lotate=new ArrayList<>();
		
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<K;i++) {
			int lot[]=new int[3];
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<3;j++) {
				lot[j]=Integer.parseInt(st.nextToken());
			}
			lotate.add(lot);
		}
		// 순서 정하기
		permutation(0);
		
		System.out.println(min);
	}
	
	private static int findMin(int[][] tmp) {
		// TODO Auto-generated method stub
		int minSum=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			int sum=0;
			for(int j=0;j<M;j++) {
				sum+=tmp[i][j];
			}
			minSum=Math.min(sum, minSum);
		}
		return minSum;
	}
	private static void permutation(int cnt) {
		// TODO Auto-generated method stub
		if(cnt==K) {
			lotate(perm);
			return;
		}
		
		for(int i=0;i<K;i++) {
			if(visited[i])
				continue;
			visited[i]=true;
			perm[cnt]=i;
			permutation(cnt+1);
			visited[i]=false;
		}
	}

	private static void lotate(int[] perm) {
		// TODO Auto-generated method stub
			// 맵 복사, 정한 순서대로 돌기
			int tmp[][]=new int[N][M];
			for(int k=0;k<N;k++) {
				tmp[k]=map[k].clone();
			}	
			
			for(int j=0;j<perm.length;j++) {
				int idx=perm[j];
				
				int lot[]=lotate.get(idx);
				int mr=lot[0]-1;
				int mc=lot[1]-1;
				int s=lot[2];

				int minr=mr-s,minc=mc-s,maxr=mr+s,maxc=mc+s;
				
				int line=Math.min(maxr-minr+1,maxc-minc+1)/2;
				
				for(int l=0;l<line;l++) {
					int r=minr+l;
					int c=minc+l;
					int d=0;
					
					int val=tmp[r][c];
					
					while(d<4) {
						int nr=r+dir[d][0];
						int nc=c+dir[d][1];
						
						if(nr==r&&nc==c)
							break;
						if(nr>=minr+l&&nc>=minc+l&&nr<=maxr-l&&nc<=maxc-l) {
							tmp[r][c]=tmp[nr][nc];
							r=nr;
							c=nc;
						}else {
							d++;
						}
					}
					tmp[minr+l][minc+l+1]=val;
				}
				
//				System.out.println(mr+" "+mc+" "+s);
//				for(int p=0;p<N;p++) {
//					for(int q=0;q<M;q++) {
//						System.out.print(tmp[p][q]+" ");
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
			// 최소값 저장하기
			min=Math.min(min, findMin(tmp));
	}

}
