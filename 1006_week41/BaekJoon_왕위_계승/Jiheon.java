package TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_5021_왕위계승 {

	static int N,M;
	static String king,children[],ans;
	static ArrayList<String> tree[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		king=bf.readLine();
		
		tree=new ArrayList[N];
		children=new String[N];
		
		for(int i=0;i<N;i++) {
			tree[i]=new ArrayList<>();
		}
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			String child=st.nextToken();
			String father=st.nextToken();
			String mother=st.nextToken();
			
			children[i]=child;
			tree[i].add(father);
			tree[i].add(mother);
		}
		
		double max=-1;
		for(int i=0;i<M;i++) {
			String name=bf.readLine();
			
			double blood=dfs(name);
			if(max<blood) {
				max=blood;
				ans=name;
			}
		}
		System.out.println(ans);
	}
	private static double dfs(String name) {
		// TODO Auto-generated method stub
		if(name.equals(king))
			return 1;

		int index=-1;
		for(int i=0;i<N;i++) {
			if(children[i].equals(name)) {
				index=i;
				break;
			}
		}
		if(index==-1)
			return 0;
		
		String father=tree[index].get(0);
		String mother=tree[index].get(1);
		
		
		return (dfs(father)+dfs(mother))/2;
	}

}
