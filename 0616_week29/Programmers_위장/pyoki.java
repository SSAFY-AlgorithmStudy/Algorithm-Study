import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Sol_616_1 {

	static HashMap<String, Integer> hm;
	static ArrayList<String> types;
	static int[] pickIdx;

	public static void main(String[] args) {

		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		solution(clothes);
	}

	public static int solution(String[][] clothes) {
		int answer = 0;
		hm = new HashMap<String, Integer>();
		for (int i = 0; i < clothes.length; i++) {

			if (hm.containsKey(clothes[i][1])) {
				int cnt = hm.get(clothes[i][1]);
				hm.put(clothes[i][1], cnt + 1);
			} else {
				hm.put(clothes[i][1], 1);

			}
		}
		int subset_cnt=1;
		Set<Map.Entry<String, Integer>> entries = hm.entrySet();
		for (Map.Entry<String, Integer> entry : entries) {
			subset_cnt *=entry.getValue()+1;
		}
		answer = subset_cnt-1;
		
		
		return answer;
	}

}
