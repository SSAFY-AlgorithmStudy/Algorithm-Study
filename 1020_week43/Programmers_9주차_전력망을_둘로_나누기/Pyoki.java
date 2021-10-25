import java.util.ArrayList;

class Solution {
    static ArrayList<ArrayList<Integer>> tree;
	static boolean [] visited;
	static int nodeCnt;
    public int solution(int n, int[][] wires) {
		tree = new ArrayList<>();
        visited= new boolean[n+1];
		for(int i=0;i<=n;i++) {
			tree.add(new ArrayList<>());
		}
		
		for(int i = 0 ; i< wires.length;i++) {
			tree.get(wires[i][0]).add(wires[i][1]);
			tree.get(wires[i][1]).add(wires[i][0]);	
		}
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=n;i++) {
			ArrayList<Integer> start  = tree.get(i);
			visited[i]=true;
            
			for(int k: start) {
                nodeCnt =1;
                visited[k]=true;
				dfs(k);
                visited[k]=false;
                //System.out.println(nodeCnt+" <-nodeCnt");
				min = Math.min(min, Math.abs((n-nodeCnt)-nodeCnt));
			}
            
			visited[i]=false;
		}
		
		int answer = min;	
		return answer;
	}
	static void dfs(int start) {

		ArrayList<Integer> nextNode = tree.get(start); 
		for(int k : nextNode ) {
			if(!visited[k]) {
				visited[k]=true;
				nodeCnt++;
				dfs(k);
                visited[k]=false;				
			}
		}
	}
}
