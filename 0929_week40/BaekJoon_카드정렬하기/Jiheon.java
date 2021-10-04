package GREEDY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715_카드정렬하기 {

	static PriorityQueue<Integer> pq=new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int sum=0;
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(bf.readLine());
		
		for(int t=0;t<tc;t++) {
			pq.add(Integer.parseInt(bf.readLine()));
		}
		
		while(pq.size()!=1) {
			int a=pq.poll();
			int b=pq.poll();
			sum+=(a+b);
			pq.add(a+b);
		}
		System.out.println(sum);
	}

}
