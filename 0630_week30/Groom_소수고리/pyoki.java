import java.io.*;
class Main {
	static boolean [] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		
		visited= new boolean[n+1];
		int []pick = new int[n+1];
		perm(pick,2,n);
	 String ans =sb.substring(0,sb.length()-1);
	 System.out.print(ans);
	}
	static boolean findPrimeNum(int num){
			for(int i=2;i<num;i++){
				int res = num%i;
				if(res ==0)return false;
			}
		return true;
	}
	
	static void perm(int []pick  ,int depth , int n){
		if(depth >n){
			int sumL =0;
			int sumR =0;
			boolean primeNumCheckL =false;
			boolean primeNumCheckR =false;
			pick[1]=1;
			for(int i=1;i<=n;i++){
				if(i==1){
					sumL = pick[n]+pick[i];
					sumR = pick[i]+pick[i+1];
				}
				else if (i==n){
					sumL = pick[n-1]+pick[i];
					sumR = pick[i]+pick[1];
				}	
				else{
					sumL = pick[i-1]+pick[i];
					sumR = pick[i]+pick[i+1];
				}
		  	primeNumCheckL = findPrimeNum(sumL);
				primeNumCheckR = findPrimeNum(sumR);
				if(!primeNumCheckL ||!primeNumCheckR ) break;
			}
			
			if(primeNumCheckL&&primeNumCheckR){
				for(int i=1;i<=n;i++) {
					if(i!=n)sb.append(pick[i]).append(' ');
					else sb.append(pick[i]);
				}
					sb.append('\n');
			}
			return;
		}
			
		for(int i=2;i<=n;i++){
			if(!visited[i]){
			  visited[i]=true;
				pick[depth]=i;
				perm(pick,depth+1,n);
				visited[i]=false;
			}
		}
	}

}