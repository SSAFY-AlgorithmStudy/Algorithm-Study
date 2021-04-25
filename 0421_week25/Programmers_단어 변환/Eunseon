public class Main_프로그래머스_단어변환 {

	public static void main(String[] args) {

		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution(begin, target, words));
	}
 
 
 //  start =========================== 
 
	public static int answer = Integer.MAX_VALUE;

	public static int solution(String begin, String target, String[] words) {

		boolean visited[] = new boolean[words.length];

		dfs(begin, target, words, 0, visited);
		
		if (answer == Integer.MAX_VALUE)
			answer = 0;
		return answer;
	}

	private static void dfs(String begin, String target, String[] words, int step, boolean[] visited) {
		if (begin.equals(target)) {
			answer = Math.min(step, answer);
			return;
		}
		if (step >= words.length) {
			return;
		}

		for (int j = 0; j < words.length; j++) { 
			if (visited[j] == false) {
				String[] str = begin.split(""); 
				String[] str2 = words[j].split(""); 

				int no = 0;

				for (int k = 0; k < str.length; k++) {
					if (str[k].equals(str2[k])) { 
					} else {
						no++;
					}
				}
					if (no == 1) {
						visited[j] = true;
						dfs(words[j], target, words, step + 1, visited);
						visited[j] = false;
					}
				}
			}
		}
	}
