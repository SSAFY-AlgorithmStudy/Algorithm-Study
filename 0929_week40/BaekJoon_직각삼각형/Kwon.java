import java.io.*;
import java.util.*;

public class Kwon {

	static final String TRUE = "right", FALSE = "wrong";

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int[] input = new int[3];
			input[0] = Integer.parseInt(st.nextToken());
			input[1] = Integer.parseInt(st.nextToken());
			input[2] = Integer.parseInt(st.nextToken());

			if (input[0] == 0 && input[1] == 0 && input[2] == 0)
				break;
			
			Arrays.sort(input);

			if (input[0]*input[0] + input[1]*input[1] == input[2]*input[2])
				sb.append(TRUE);
			else
				sb.append(FALSE);

			sb.append('\n');
		}

		System.out.println(sb);
	}
}