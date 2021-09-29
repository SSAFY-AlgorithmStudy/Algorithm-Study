import java.io.*;
import java.util.*;

public class Kwon {

	static final int GEAR_CNT = 4, EDGE_CNT = 8;
	static int K;
	static Deque<Integer>[] gears;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		gears = new LinkedList[GEAR_CNT];
		for (int i = 0; i < GEAR_CNT; i++) {
			gears[i] = new LinkedList<>();
			String input = bf.readLine();
			for (int j = 0; j < EDGE_CNT; j++) {
				gears[i].add(input.charAt(j) - '0');
			}
		}

		K = Integer.valueOf(bf.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());

			Queue<int[]> orders = new LinkedList<>();
			int index = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());

			orders.add(new int[] { index, d });

			int curD = -d;
			int left = getLeft(index);
			for (int leftIndex = index - 1; leftIndex >= 0; leftIndex--) {
				if (left + getRight(leftIndex) == 1) {
					orders.add(new int[] { leftIndex, curD });
					left = getLeft(leftIndex);
					curD *= -1;
				} else {
					break;
				}
			}

			curD = -d;
			int right = getRight(index);
			for (int rightIndex = index + 1; rightIndex < GEAR_CNT; rightIndex++) {
				if (right + getLeft(rightIndex) == 1) {
					orders.add(new int[] { rightIndex, curD });
					right = getRight(rightIndex);
					curD *= -1;
				} else {
					break;
				}
			}

			while (!orders.isEmpty()) {
				int[] cur = orders.poll();

				int gearIndex = cur[0];
				int rotateDir = cur[1];

				rotate(gearIndex, rotateDir);
			}
		}

		int answer = 0;
		for (int i = 0; i < GEAR_CNT; i++) {
			if (gears[i].peek() == 1)
				answer += (1 << i);
		}

		System.out.println(answer);

	}

	public static void rotate(int index, int d) {
		if (d == 1) {
			int tail = gears[index].pollLast();
			gears[index].addFirst(tail);
		} else {
			int head = gears[index].pollFirst();
			gears[index].addLast(head);
		}
	}

	public static int getLeft(int index) {
		int last = gears[index].pollLast();
		int ret = gears[index].peekLast();
		gears[index].addLast(last);
		return ret;
	}

	public static int getRight(int index) {
		int first = gears[index].pollFirst();
		int second = gears[index].pollFirst();
		int ret = gears[index].peekFirst();
		gears[index].addFirst(second);
		gears[index].addFirst(first);
		return ret;
	}
}