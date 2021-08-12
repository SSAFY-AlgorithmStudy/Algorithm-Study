import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		ArrayList<String> temp = new ArrayList<>();
		HashSet<String> hs = new HashSet<>();
			for (int i = 0; i < str.length(); i++) {
				String inputStr =str.substring(i);
				if(!hs.contains(inputStr)) {
					temp.add(str.substring(i));
				}
			}
		Collections.sort(temp);
		for (String s : temp) {
			sb.append(s).append('\n');
		}
		System.out.println(sb);
	}
}

