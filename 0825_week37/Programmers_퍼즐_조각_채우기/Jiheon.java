package 구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class pg_퍼즐조각 {
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }, size, answer = 0;
	static ArrayList<Point[]> puzzle = new ArrayList<>();
	static Queue<Point> q;
	static boolean visited[][], findPuzzle[][];

	public static void main(String[] args) {
		int[][] game_board = { { 1, 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 0, 1 }, { 1, 1, 0, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 0 }, { 0, 1, 1, 1, 0, 0 } };
		int[][] table = { { 1, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 1, 1 }, { 0, 0, 1, 0, 0, 0 },
				{ 1, 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0, 0 } };
//		   int[][] game_board= {{1,1,1},{1,0,1},{0,0,0}};
//		   int[][] table= {{1,0,0},{0,1,0},{1,1,1}};
		// TODO Auto-generated method stub
//		 	int answer = -1;

		size = game_board.length;

		// table에서 퍼즐 찾기
		visited = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (table[i][j] == 1 && !visited[i][j]) {
					puzzle.add(findPuzzle(i, j, table, 0));
				}
			}
		}
		// 게임보드에서 빈칸 찾기
		findPuzzle = new boolean[size][size];
		visited = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (game_board[i][j] == 0 && !findPuzzle[i][j]) {
					// 모양,크기찾고 i,j기준으로 퍼즐맞추기
					Point[] blank = findPuzzle(i, j, game_board, 1);
					int idx = 0, cnt = blank.length;
					boolean find = false;

					for (int k = 0; k < puzzle.size(); k++) {
						Point[] tmp = puzzle.get(k);
						if (tmp.length == cnt) {
							if (checkPuzzle(i,j,blank, tmp)) {
								find = true;
								idx = k;
							}
						}
					}
					if (find) {
						puzzle.remove(idx);
						answer += cnt;
						for (int k = 0; k < blank.length; k++) {
							findPuzzle[blank[k].x][blank[k].y] = true;
						}
					}else {
						for (int k = 0; k < blank.length; k++) {
							visited[blank[k].x][blank[k].y] = false;
						}
					}
				}
			}
		}
		System.out.println(answer);

//	        return answer;
	}

	// 시계방향 회전 (A,B)->(B,-A)
	// 반시계방향 회전 (A,B)->(-B,A)
	private static boolean checkPuzzle(int r,int c,Point blank[], Point tmp[]) {
		// TODO Auto-generated method stub
			
		for (int dir = 0; dir < 4; dir++) {
			boolean res = true;
			Point[] locate=new Point[tmp.length];
			for(int i=0;i<locate.length;i++) {
				locate[i]=new Point(tmp[i].x+r,tmp[i].y+c);
			}
			
			Arrays.sort(blank);
			Arrays.sort(locate);
			
			for(int j=0;j<blank.length;j++) {
				if(locate[j].x!=blank[j].x||locate[j].y!=blank[j].y)
					res=false;
			}
			if(res)
				return res;
			
			for (int k = 0; k < tmp.length; k++) {
				int tmpPoint = tmp[k].y;
				tmp[k].y = tmp[k].x * -1;
				tmp[k].x = tmpPoint;
			}

		}
		return false;
	}

	static Point[] findPuzzle(int r, int c, int[][] map, int flag) {
		ArrayList<Point> list = new ArrayList<>();
		q = new LinkedList<>();
		visited[r][c] = true;
		q.add(new Point(r, c));

		while (!q.isEmpty()) {
			Point p = q.poll();
			list.add(p);
			int mr = p.x;
			int mc = p.y;

			for (int i = 0; i < dir.length; i++) {
				int nr = mr + dir[i][0];
				int nc = mc + dir[i][1];

				if (nr < 0 || nc < 0 || nr >= size || nc >= size || visited[nr][nc] || map[nr][nc] == flag)
					continue;
				else {
					visited[nr][nc] = true;
					q.add(new Point(nr, nc));
				}
			}
		}

		Point[] p = new Point[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Point tmp = list.get(i);
			if (flag == 0)
				p[i] = new Point(tmp.x - r, tmp.y - c);
			else
				p[i] = new Point(tmp.x, tmp.y);
		}

		return p;
	}

}

class Point implements Comparable<Point>{

	int x,y;
	
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		if(this.x<o.x) 
			return -1;
		else if(this.x==o.x) {
			if(this.y<o.y)
				return -1;
			else
				return 1;
		}
		else
			return 1;
	}
	
}
