package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_21608_상어초등학교 {

	static int N, map[][],ans=0, dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean sitted[][];
	static List<seat> sList = new ArrayList<>();
	static List<blank> bList;
	static PriorityQueue<blank> pq;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(bf.readLine());

		map = new int[N][N];
		sitted = new boolean[N][N];

		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(bf.readLine());
			seat seat = new seat(Integer.parseInt(st.nextToken()));
			for (int j = 0; j < 4; j++) {
				seat.like[j] = Integer.parseInt(st.nextToken());
			}
			sList.add(seat);
		}
		pq = new PriorityQueue<>(new Comparator<blank>() {
			@Override
			public int compare(blank o1, blank o2) {
				// TODO Auto-generated method stub
				// 내림차순
				if (o2.likeCount > o1.likeCount)
					return 1;
				else if (o2.likeCount == o1.likeCount) {
					if (o2.bCount > o1.bCount)
						return 1;
					else if (o2.bCount == o1.bCount) {
						if (o1.p.x > o2.p.x) {
							return 1;
						} else if (o1.p.x == o2.p.x) {
							return o1.p.y - o2.p.y;
						} else
							return -1;
					} else
						return -1;
				} else
					return -1;
			}
		});

		for (int i = 0; i < sList.size(); i++) {
			seat s = sList.get(i);
			bList = new ArrayList<>();
			pq.clear();
			find(s);
		}

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int num=map[i][j];
				count(num,i,j);
			}
		}
		
		System.out.println(ans);

	}

	private static void count(int num,int r,int c) {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=0;i<sList.size();i++) {
			seat s=sList.get(i);
			if(num==s.index) {
				
				for (int d = 0; d < 4; d++) {
					int nr = r + dir[d][0];
					int nc = c + dir[d][1];

					if (nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					
					for (int k = 0; k < 4; k++) {
						if (map[nr][nc] == s.like[k]) {
							count++;
						}
					}
				}
			}
		}
		
		if(count==2) {
			ans+=10;
		}else if(count==3) {
			ans+=100;
		}else if(count==4) {
			ans+=1000;
		}else
			ans+=count;
	}

	private static void find(seat s) {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!sitted[i][j]) {
					blank blank = new blank(i, j);
					for (int d = 0; d < 4; d++) {
						int nr = i + dir[d][0];
						int nc = j + dir[d][1];

						if (nr < 0 || nc < 0 || nr >= N || nc >= N)
							continue;

						for (int k = 0; k < 4; k++) {
							if (map[nr][nc] == s.like[k]) {
								blank.likeCount++;
							}
						}

						if (!sitted[nr][nc])
							blank.bCount++;
					}
					pq.add(blank);
				}
			}
		}

		blank top = pq.poll();
		Point p = top.p;
		sitted[p.x][p.y] = true;
		map[p.x][p.y] = s.index;
	}

}

class seat {
	int index;
	int like[] = new int[4];

	public seat(int num) {
		this.index = num;
	}
}

class blank {
	int likeCount;
	int bCount;
	Point p;

	public blank(int r, int c) {
		p = new Point(r, c);
		this.likeCount = 0;
		this.bCount = 0;
	}
}
