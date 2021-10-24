package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_1089_스타트링크타워 {

	static String nums[] = { "####.##.##.####", "..#..#..#..#..#", "###..#####..###", "###..####..####",
			"#.##.####..#..#", "####..###..####", "####..####.####", "###..#..#..#..#", "####.#####.####",
			"####.####..####" };
	static double sum = 0;
	static int total = 1;
	static char map[][];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		map = new char[5][4 * N - 1];
		int res[][]=new int[N][10];
		
		for (int i = 0; i < 5; i++) {
			map[i] = bf.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			int[] arr=findNumber(i);
			if(arr.length==0) {
				System.out.println("-1");
				return;
			}
			//총 가짓수
			total*=arr.length;
			res[i]=Arrays.copyOf(arr, arr.length);
		}
		
		//총 합 구하기
		for(int i=0;i<N;i++) {
			for(int j=0;j<res[i].length;j++) {
				sum+=(Math.pow(10, N-1-i)*res[i][j])*total/res[i].length;							
			}
		}
		System.out.println(sum/total);
	}

	private static int[] findNumber(int num) {
		// TODO Auto-generated method stub
		int start = num * 4, end = start + 2;
		String tmp = "";
		ArrayList<Integer> list=new ArrayList<>();
		
		for (int r = 0; r < 5; r++) {
			for (int c = start; c <= end; c++) {
				tmp += map[r][c];
			}
		}
		
		for(int i=0;i<nums.length;i++) {
			String number=nums[i];
			boolean flag=false;
			if(number.equals(tmp)) {
				list.add(i);
				continue;
			}else {
				for(int j=0;j<tmp.length();j++) {
					if(tmp.charAt(j)=='#'&&number.charAt(j)=='.') {
						flag=true;
						break;
					}
				}
				if(!flag)
					list.add(i);
			}
		}
//			for(int i=0;i<list.size();i++) {
//				System.out.print(list.get(i)+" ");
//			}
//			System.out.println();
		
		int[] arr=new int[list.size()];
		for(int i=0;i<list.size();i++) {
			arr[i]=list.get(i);
		}
		return arr;
		
	}

}
