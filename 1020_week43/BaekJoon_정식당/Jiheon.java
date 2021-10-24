package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_17479_정식당 {

	static Map<String,Integer> menu=new HashMap<>();
	static Map<String,Integer> special=new HashMap<>();
	static Set<String> service=new HashSet<>();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<A;i++) {
			st=new StringTokenizer(bf.readLine());
			String name=st.nextToken();
			int price=Integer.parseInt(st.nextToken());
			
			menu.put(name, price);
		}
		
		for(int i=0;i<B;i++) {
			st=new StringTokenizer(bf.readLine());
			String name=st.nextToken();
			int price=Integer.parseInt(st.nextToken());
			
			special.put(name, price);
		}
		
		for(int i=0;i<C;i++) {
			String name=bf.readLine();
			service.add(name);
		}
		
		int cnt=Integer.parseInt(bf.readLine());
		
		long menuSum=0,specialSum=0;
		int menuCnt=0,specialCnt=0,serviceCnt=0;
		for(int i=0;i<cnt;i++) {
			String name=bf.readLine();
			if(menu.containsKey(name)) {
				menuSum+=menu.get(name);
				menuCnt++;
			}else if(special.containsKey(name)) {
				specialSum+=special.get(name);
				specialCnt++;
			}else if(service.contains(name)) {
				serviceCnt++;
			}
		}
		
		if((menuSum<20000&&specialCnt>=1)||(menuSum+specialSum<50000&&serviceCnt>=1)
				||(serviceCnt>1))
			System.out.println("No");
		else
			System.out.println("Okay");
	}

}
