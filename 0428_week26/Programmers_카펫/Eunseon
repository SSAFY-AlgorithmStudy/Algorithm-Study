
public class Main_프로그래머스_카펫 {

	public static void main(String[] args) {
		int arr[] = solution(10, 2);
	    System.out.println(arr[0]+" "+arr[1]);
	}

	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int sum = brown + yellow;

		for (int i = 2; i <= sum / 2; i++) {
			int x = sum / i;
			int y = sum / x;
			if (y > x)
				continue;
			if ((x * 2 + y * 2 - 4) == brown) {
				answer[0] = x;
				answer[1] = y;
				break; 
			}
		} // end of for

		return answer;
	}

}
