

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10973_이전순열        {

	public static int arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // end of for

		int flag = 0;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				flag = 1;
				break;
			} // end of for
		} // end of for

		// 만약, 오름차순으로 되어있다면 -1를 출력하고 리턴한다.
		if (flag == 0) {
			System.out.println(-1);
			return;
		}

		next_permutation(n);

		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				System.out.println(arr[i]);
			} else {
				System.out.print(arr[i] + " ");
			}

		}

	}// end of main

	private static void next_permutation(int n) {

//		1. Arrays.sort(arr)를 한다. (오름차순으로 정렬한다.)
//		2. 뒤쪽에서 탐색하며 꼭대기를 찾아야함( 뒤에서 시작했을 때 오름차순이 끝나는 지점)
//		3. i-1위치와 교환할 큰 값을 찾기 
//		4. 그리고 i-1과 j의 값을 교환하기 
//		5. 꼭대기부터 뒤까지 오름차순으로 정렬하기  

		// index : 꼭대기
		int index = n - 1;
		// 2. 꼭대기 찾기 (내림차순이 끝나는 지점)
		for (int i = n - 1; i > 0; i--) {
			if (arr[i] < arr[i - 1]) { // 만약, 1 2 3 4 -> 1 2 4 3
				index = i - 1;
				break;
			}
			index--;
		} 
		// 빼먹은 부분 : 꼭대기보다 큰 값 중 가장 작은 값 찾기 ->이 부분을 빼먹어서 무한루프 돌았다.
		int index2 = n - 1;
		int num = Integer.MIN_VALUE;
		for (int i = index + 1; i < arr.length; i++) {
			if (arr[index] > arr[i]) {
				num = Math.max(num, arr[i]);
				index2 = i;
			}
		}

		if (num == Integer.MIN_VALUE) {
			index2 = arr.length - 1;
		}

//   (4)

		swap(arr, index, index2);

		index2 = n-1; 
		index = index+1; 
//	 (5) 
		while(index<index2) {
			swap(arr, index++,index2--);
		}

	}// end of next_permutaion method

	private static void swap(int[] arr, int index, int n) {

		int number = arr[index];
		arr[index] = arr[n];
		arr[n] = number;

	}// end of swap method

}// end of class

