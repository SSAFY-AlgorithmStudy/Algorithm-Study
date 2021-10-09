import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] pick_dwarf;
	static int[] dwarf_height;
	static boolean[] visited;
	static boolean answerCheck;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dwarf_height = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			dwarf_height[i] = Integer.parseInt(br.readLine());
			sum += dwarf_height[i];
		}
		visited = new boolean[9];
		pick_dwarf = new int[2];
		answerCheck = false;
		pick(0, 0, sum);

		Arrays.sort(dwarf_height);

		for (int i = 2; i < 9; i++) {
			System.out.println(dwarf_height[i]);
		}
	}

	public static void pick(int depth, int start, int sum) {
		if (depth == 2) {
			int cnt = 0;
			if ((sum - 100) == (pick_dwarf[0] + pick_dwarf[1]) && !answerCheck) {
				for (int i = 0; i < 9; i++) {
					if (cnt == 2)
						break;
					if (pick_dwarf[0] == dwarf_height[i]) {
						dwarf_height[i] = 0;
						pick_dwarf[0] = -1;
						cnt++;
					} else if (pick_dwarf[1] == dwarf_height[i]) {
						dwarf_height[i] = 0;
						pick_dwarf[1] = -1;
						cnt++;
					}
				}
				
				answerCheck =true;
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				pick_dwarf[depth] = dwarf_height[i];
				pick(depth + 1, i + 1, sum);
				visited[i] = false;
			}
		}

	}
}

