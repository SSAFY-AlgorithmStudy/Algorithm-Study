package Programmers;

public class ¿ÏÀüÅ½»ö_Ä«Æê {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(24,24);
	}
	
	static public int[] solution(int brown, int yellow) {
        int[] answer =new int[2];
        
        double x1=((brown/2+2)+Math.sqrt(Math.pow(brown/2+2,2)-4*(brown+yellow)))/2;
        double y1=brown/2+2-x1;
        double x2=((brown/2+2)-Math.sqrt(Math.pow(brown/2+2,2)-4*(brown+yellow)))/2;
        double y2=brown/2+2-x2;
        System.out.println(x1+" "+y1);
        System.out.println(x2+" "+y2);
        
        answer[0]=(int)x1;
        answer[1]=(int)y1;
        return answer;
    }
	

}
