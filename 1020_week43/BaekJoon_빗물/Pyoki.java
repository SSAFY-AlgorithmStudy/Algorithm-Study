import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int [] hArray = new int [L];
		boolean []fill =new boolean[L];
		st = new StringTokenizer(br.readLine());
		int maxH=Integer.MIN_VALUE;

		int answer=0;
		int water =0;
		int maxH_x=-1;
		for(int i=0;i<L;i++) {
			hArray[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<L;i++) {
		if(hArray[i]>=maxH) {
			
		}
			if(hArray[i]>=maxH) {
				if(maxH_x!=-1) {
					for(int j=maxH_x;j<i;j++) {
						fill[j]=true;
					}
				}
		   maxH=hArray[i];
		   maxH_x=i;
		   answer+= water;
		   water=0;
		}else {
		  water+=maxH-hArray[i];
		}
		
		}
		
		
		water =0;
		maxH=Integer.MIN_VALUE;
		
		for(int i=L-1;i>=0;i--) {
			if(hArray[i]>=maxH) {
				   maxH=hArray[i];
				   maxH_x=i;
				   answer+= water;
				   water=0;
				}else {
					if(!fill[i])
				  water+=maxH-hArray[i];
				}
		}
		
		System.out.println(answer);
	}

}

