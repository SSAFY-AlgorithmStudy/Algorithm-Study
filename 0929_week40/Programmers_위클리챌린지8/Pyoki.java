import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
     int maxRowLine = Integer.MIN_VALUE;
		for (int i = 0; i < sizes.length; i++) {
			for (int j = 0; j < 2; j++) {
				maxRowLine = Math.max(maxRowLine, sizes[i][j]);
			}
		}
		int maxColLine = Integer.MIN_VALUE;
		for (int i = 0; i < sizes.length; i++) {
			if(sizes[i][0]>=sizes[i][1]) {
				maxColLine = Math.max(maxColLine, sizes[i][1]);
			}else {
				maxColLine = Math.max(maxColLine, sizes[i][0]);
			}
		}
		int answer = 0;
		answer = maxRowLine*maxColLine;
		return answer;
    }
}
