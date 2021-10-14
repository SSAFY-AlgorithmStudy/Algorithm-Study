import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String [] S = new String [N];
		String [] inspectStr = new String[M];
		boolean [] prefixStr = new boolean[M];
		for(int i =0; i<N;i++) {
				S[i]= br.readLine();
		}
		for(int i =0 ; i<M;i++) {
			inspectStr[i] = br.readLine();
		}
		
		int cnt =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!prefixStr[j]){
                if(prefixCheck(S[i],inspectStr[j])) {
					prefixStr[j]=true;
                    cnt++;
				}
               }
			}
		}
		System.out.println(cnt);
	}
	static boolean prefixCheck(String s, String is) {
		for(int i =0;i<is.length();i++) {
			if(is.charAt(i)!=s.charAt(i)) {
				return false;
			}
		}
		return true;
	}

}

