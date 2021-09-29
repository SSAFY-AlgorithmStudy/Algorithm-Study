import java.io.*;
import java.util.*;

public class Kwon {

	static int N, M;
	static boolean[] people;
	static boolean[] party;
	static ArrayList<Integer>[] partyPerPeople;
	static ArrayList<Integer>[] peoplePerParty;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		people = new boolean[N + 1];
		partyPerPeople = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			partyPerPeople[i] = new ArrayList<>();
		}

		st = new StringTokenizer(bf.readLine());
		int knownCnt = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < knownCnt; i++) {
			int person = Integer.parseInt(st.nextToken());
			q.add(person);
		}

		party = new boolean[M];
		peoplePerParty = new ArrayList[M];
		for (int partyIndex = 0; partyIndex < M; partyIndex++) {
			peoplePerParty[partyIndex] = new ArrayList<>();

			st = new StringTokenizer(bf.readLine());
			int cnt = Integer.parseInt(st.nextToken());

			for (int i = 0; i < cnt; i++) {
				int person = Integer.parseInt(st.nextToken());

				partyPerPeople[person].add(partyIndex);
				peoplePerParty[partyIndex].add(person);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (people[cur])
				continue;
			people[cur] = true;

			for (int partyIndex : partyPerPeople[cur]) {
				party[partyIndex] = true;

				for (int person : peoplePerParty[partyIndex]) {
					if (!people[person]) {
						q.add(person);
					}
				}
			}
		}

		int answer = 0;
		for (boolean p : party) {
			if (!p)
				answer++;
		}

		System.out.println(answer);
	}
}