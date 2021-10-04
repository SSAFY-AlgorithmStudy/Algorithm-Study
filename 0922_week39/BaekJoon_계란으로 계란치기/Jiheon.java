package BackTracking;

import java.util.Scanner;

public class BOJ_16987_계란으로계란치기 {

	static int egg[][],n,ans=0;
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		egg=new int[n][2];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<2;j++) {
				egg[i][j]=sc.nextInt();
			}
		}
		
		dfs(0);
		System.out.println(ans);
		sc.close();
	}
	
	static void dfs(int idx) {
		if(idx>=n) {
			int cnt=0;
			for(int i=0;i<n;i++) {
				if(egg[i][0]<=0) {
					cnt++;	// ���� �ܶ� ����
				}
			}
			if(ans<cnt)
				ans=cnt;
			return;
		}
		if(egg[idx][0]<=0)
			dfs(idx+1);	//���������� ���� ���
		else {
			boolean flag=false;	// ���߷ȴ��� �ȱ��߷ȴ���
			for(int i=0;i<n;i++) {
				if(idx==i||egg[i][0]<=0) {
					continue;	// �ڱⰡ���̰ų� ���������� �Ѿ��
				}
				egg[idx][0]=egg[idx][0]-egg[i][1];
				egg[i][0]=egg[i][0]-egg[idx][1];
	            flag = true;	//���߸�
	            dfs(idx + 1); //������
	            egg[i][0] = egg[i][0] + egg[idx][1];	//back tracking
	            egg[idx][0] = egg[idx][0] + egg[i][1];
			}
			if(flag==false)
				dfs(n);	
			
		}
		
		
	}
}
