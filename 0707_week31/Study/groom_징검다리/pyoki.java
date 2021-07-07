import java.io.*;
import java.util.*;

class Main {
	static ArrayList<Integer> al = new ArrayList<>();
	static int answer;
	static int d,n,m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 d = Integer.parseInt(st.nextToken());
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			al.add(num);
		}
		Collections.sort(al);
		answer =Integer.MIN_VALUE;
		int size = n-m;
		int [] pick = new int[size];
		pickIdx(pick,0,0,size-1);
		System.out.print(answer);
	}
	static void pickIdx(int [] pick ,int start ,int depth, int cnt){
		
			if(depth>cnt){
				 int min = calMin(pick);
				 answer = Math.max(answer,min);
				return;
			}
		for(int k=start;k<n;k++){
						pick[depth]=k;
						pickIdx(pick,k+1,depth+1,cnt);			
			}
	}
	static int calMin(int [] pick){
		int res =Integer.MAX_VALUE;
		int start =0;
		for(int i=0;i<pick.length;i++){
			int next = al.get(pick[i]);
			int len = next-start;
			start = next;
			res = Math.min(res,len);
		}
			res = Math.min(res,d-start);
		return res;
	}
}