import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    static HashMap<String, Integer> hm;
	static char[] arr;
	static ArrayList<String> words;
    public int solution(String word) {
      int answer = 0;
		hm = new HashMap<>();
		arr = new char[5];
		arr[0] = 'A';
		arr[1] = 'E';
		arr[2] = 'I';
		arr[3] = 'O';
		arr[4] = 'U';
		words = new ArrayList<>();
		int [] pick = new int[5];
		setOrder(pick,0);
		Collections.sort(words);
		for(int i=0;i<words.size();i++) {
			String str =words.get(i);
			hm.put(str,i);
		}
		
		answer =hm.get(word);
		return answer;
    }
    public static void setOrder(int [] pick, int depth) {
		
		StringBuilder sb = new StringBuilder();
		for(int k =0;k<depth;k++) {
			sb.append(arr[pick[k]]);
		}
		words.add(sb.toString());
		if(depth>4) {
			
			return;
		}
	
		for(int i=0;i<5;i++) {
			 pick[depth]=i;
			 setOrder(pick,depth+1);
		}
	}
}
