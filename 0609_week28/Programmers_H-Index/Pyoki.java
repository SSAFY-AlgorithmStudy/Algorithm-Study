import java.io.IOException;
import java.util.Arrays;

public class Sol_609 {

	public static void main(String[] args) throws IOException {

		int [] citations = {3,0,6,1,5};
		System.out.println(solution(citations));
	}

	 
	    public static int solution(int[] citations) {
	        int answer = 0;
	        
	        Arrays.sort(citations);
	        int cnt = 1;
	        int h_idx=0;
	        for(int i=citations.length-1;i>=0;i--) {
	        	if(citations[i] >=cnt) {
	        		h_idx = cnt;
	        	}
	        	cnt++;
	        	 
	        }
	        answer = h_idx;
	        return answer;
	    }
	
}

