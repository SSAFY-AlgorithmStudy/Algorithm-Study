import java.io.*;
class Main {
	
	static int N;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.valueOf(bf.readLine());
		selected = new int[N];
		
		makeRing(0, 0);
		sb.setLength(sb.length() - 1);
		
		System.out.println(sb);
	}
	public static void makeRing(int cnt, int flag){
		if(cnt == N){
			if(selected[0] == 1 && possible(selected)){
				for(int num : selected){
					sb.append(num).append(' ');
				}
				sb.setLength(sb.length() - 1);
				sb.append('\n');
			}
			return;
		}
		for(int i = 1; i <= N; i++){
			if((flag & (1 << i)) != 0) continue;
			selected[cnt] = i;
			makeRing(cnt + 1, flag | (1 << i));
		}
	}
	
	public static boolean possible(int[] arr){
		for(int i = 0; i < N - 1; i++){
			int num = arr[i] + arr[i + 1];
			
			if(!isPrime(num)){
				return false;
			}
		}
		
		return isPrime(arr[0] + arr[N - 1]);
	}
	
	public static boolean isPrime(int num){
		for(int i = 2; i < num / 2 + 1; i++){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}
}