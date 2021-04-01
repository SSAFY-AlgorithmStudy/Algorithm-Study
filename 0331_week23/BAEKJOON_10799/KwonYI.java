import java.io.*;
import java.util.*;

public class BAEK_10799 {

	static class Beam {
		int start;
		int end;

		public Beam(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	static Stack<Integer> open = new Stack<>(); // ) 에 맞는 ( 위치 계산

	static ArrayList<Integer> stickStart = new ArrayList<>(); // 쇠막대기의 ( 의 위치
	static ArrayList<Integer> stickEnd = new ArrayList<>(); // ) 의 위치
	static ArrayList<Beam> beams = new ArrayList<>(); // 레이저 위치

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String stick = bf.readLine();

		for (int cur = 0; cur < stick.length(); cur++) {
			char point = stick.charAt(cur);

			if (point == '(') {
				open.add(cur);
			} else {
				int pos = open.pop(); // 가장 먼저 들어간 (의 위치 뺸다

				if (cur - pos == 1) { // 둘의 차이가 1이면 레이저 나오는 곳
					beams.add(new Beam(pos, cur));
				} else { // 아니면 막대
					stickStart.add(pos);
					stickEnd.add(cur);
				}
			}
		}

		int cnt = 0;

		for (int i = 0; i < stickStart.size(); i++) {
			int start = stickStart.get(i);
			int end = stickEnd.get(i);

			int curCnt = 1;

			for (Beam beam : beams) {
				if (beam.start > start && beam.end < end) {
					curCnt++;
				}
			}
			cnt += curCnt;
		}

		System.out.println(cnt);
	}
}
