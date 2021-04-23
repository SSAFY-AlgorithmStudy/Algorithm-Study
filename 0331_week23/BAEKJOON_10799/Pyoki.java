package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Pyoki{
		
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String str  = br.readLine();
		
		
		boolean [] laserCheck = new boolean[str.length()];
		
		for(int i=0;i<str.length()-1;i++) {
			if(str.charAt(i) =='(' && str.charAt(i+1)==')') {
				laserCheck[i]=true;
				laserCheck[i+1]=true;
			}
		}
		
		Stack<Character> stack = new Stack<>();

		int cnt =0;
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) =='('  && !laserCheck[i]) {
				stack.push('(');
				cnt++;
			}
			if(str.charAt(i) ==')'  && !laserCheck[i]) {
				stack.pop();
			}
			if(str.charAt(i) =='('  && laserCheck[i]) {
				cnt +=stack.size();
			}
				
		}
		System.out.println(cnt);
	}
}
