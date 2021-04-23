
public class pro_단어변환 {
	static boolean[] visited;
	static int min;
	
	public static void main(String[] args) {
		
		String begin ="hit";
		String target="cog";
		String[] words= {"hot", "dot", "dog", "lot", "log", "cog"};
		
		System.out.println(solution(begin,target,words));
	}

	static public int solution(String begin, String target, String[] words) {
		int answer = 0;
		
		visited = new boolean[words.length];
		min = Integer.MAX_VALUE;
		dfs(begin,target,words,0);
		if(min != Integer.MAX_VALUE) answer=min;
		return answer;
	}

	static public void dfs(String begin, String target, String[] words, int depth) {
	
		if(depth>words.length) {
			return;
		}
		if(begin.equals(target)) {
			min = Math.min(min, depth);
			return;
		}
		
			for (int j = 0; j < words.length; j++) {
				if (!visited[j]) {
						int checkCnt =0;
						for(int k=0;k<begin.length();k++) {
							if(words[j].charAt(k) !=begin.charAt(k)) {
								checkCnt++;	
							}							
						}
						if(checkCnt==1) {
							visited[j]=true;
							dfs(words[j],target,words,depth+1);
							visited[j]=false;
						}

					}
				}

	}
}
