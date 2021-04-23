
public class pro_네트워크 {
		static boolean []visited;

 public  static int solution(int n, int[][] computers) {
	        int answer = 0;
	        visited = new boolean[n];
	        for(int i=0;i<n;i++) {
	        	if(!visited[i]) {
	        		answer++;
	        		dfs(n,computers,i);
	        	}
	        }
	        return answer;
	    }
 
	 public static void dfs(int n,int[][] computers,int start) {
		 
		 for(int j=0;j<n;j++) {
			 if(computers[start][j]==1) {
				 if(!visited[j]) {
					 visited[j]=true;
					 dfs(n,computers,j);
				 }
			 }
		 }
		 
	 }
}
