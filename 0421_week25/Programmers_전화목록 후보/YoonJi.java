package Programmers;

import java.util.Arrays;

public class 해시_전화번호목록 {
	static String[] phone_book= {"12","123","1235","567","88"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean answer=true;
		
		Arrays.sort(phone_book);
		
		for (int i = 0; i <phone_book.length; i++) {
			int tmpLength=phone_book[i].length();
			for (int j = 0; j < phone_book.length; j++) {
				//길이는 더 길면서 접두사이면
				if(i!=j&&tmpLength<phone_book[j].length()) {
					if(phone_book[j].substring(0,tmpLength).equals(phone_book[i])) {
						answer=false;
						System.out.println(false);
						return;
					}
				}
			}
		}
		
		System.out.println(answer);
		return;
	}

}
