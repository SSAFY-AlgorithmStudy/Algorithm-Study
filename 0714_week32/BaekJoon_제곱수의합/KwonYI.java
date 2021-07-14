import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int day = 1;
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int L = A - B;
		
		V -= A;
		
		if(V % L != 0) {
			day += (V / L + 1);
		}else {
			day += V / L;
		}
		
		System.out.println(day);
	}
}