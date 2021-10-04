package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17609_회문 {

	static int T,res[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(bf.readLine());
		res=new int[T];
		
		for(int i=0;i<T;i++) {
			String word=bf.readLine();
			res[i]=check(word);
		}
		
		for(int i=0;i<T;i++) {
			System.out.println(res[i]);
		}
	}
	private static int check(String word) {
		// TODO Auto-generated method stub
		int flag=0;
		char[] arr=word.toCharArray();
		int left=0,right=word.length()-1;
		
		while(left<=right) {
			if(arr[left]==arr[right]) {
				left++;
				right--;				
			}
			else if(arr[left]!=arr[right]){
				flag++;
				int nl=left+1;
				int nr=right;
				
				while(nl<=nr) {
					if(arr[nl]==arr[nr]) {
						nl++;
						nr--;				
					}
					else {
						flag++;
						break;
					}
				}
				
				nl=left;
				nr=right-1;
				
				while(nl<=nr) {
					if(arr[nl]==arr[nr]) {
						nl++;
						nr--;				
					}
					else {
						flag++;
						break;
					}
				}
				return flag;
			}
		}
		return flag;
	}

}
