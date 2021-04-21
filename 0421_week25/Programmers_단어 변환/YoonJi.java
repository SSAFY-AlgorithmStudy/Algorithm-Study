package Programmers;

public class 단어변환 {
	static String begin="hit";
	static String target="cog";
	static String[] words= {"hot", "dot", "dog", "lot", "log"};
	static int result=0,min=Integer.MAX_VALUE;
	public static void main(String[] args) {
	
		int answer=0;
		boolean visited[]=new boolean[words.length];
		boolean flag=false;
		
		for (int i = 0; i < words.length; i++) {
			if(check(begin,words[i])) {
				visited[i]=true;
				dfs(words[i],1,visited);
			}
			if(target.equals(words[i])) {
				flag=true;
			}
		}
		
		if(flag==false) {
			System.out.println("0");
		}
		
		else System.out.println(min);
	}
	
	static void dfs(String s,int cnt,boolean visited[]) {
		if(s.equals(target)) {
			min=Math.min(min,cnt);
			return;
		}
		
		for (int i = 0; i < words.length; i++) {
			if(!visited[i]&&check(s,words[i])) {
				visited[i]=true;
				dfs(words[i],cnt+1,visited);
				visited[i]=false;
			}
		}
	}
	
	static boolean check(String a,String b) {
		int number=0;
		for (int i = 0; i < a.length(); i++) {
			if(a.charAt(i)!=b.charAt(i)) {
				number++;
			}
		}
		
		if(number==1) return true;
		else return false;
	}

}
