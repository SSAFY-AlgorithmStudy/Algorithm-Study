import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = bf.readLine();
		String bomb = bf.readLine();

		for (int i = 0; i < input.length(); i++) {
			sb.append(input.charAt(i));

			if (sb.length() >= bomb.length() && sb.substring(sb.length() - bomb.length(), sb.length()).equals(bomb)) {
				sb.setLength(sb.length() - bomb.length());
			}
		}
		
		if(sb.length() == 0) {
			System.out.print("FRULA");
		}else {
			System.out.println(sb);
		}
	}
}