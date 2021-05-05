package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 키패드누르기 {
    static public class Point{
        int x,y,cnt;
        public Point(int x,int y,int cnt){
            this.x=x;
            this.y=y;
            this.cnt=cnt;
        }
    }
    
    static Queue<Point> left=new LinkedList<Point>();
    static Queue<Point> right=new LinkedList<Point>();
    
    static int arr[][]=new int[4][3];
    static int dx[]={-1,1,0,0};
    static int dy[]={0,0,-1,1};
    static boolean visited[][];
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	    static String solution(int[] numbers, String hand) {
	        StringBuffer answer =new StringBuffer();
	        
	        int tmp=1;
	        for(int i=0;i<3;i++){
	            for(int j=0;j<3;j++){
	                arr[i][j]=tmp++;
	            }
	        }
	        
	        arr[3][0]=arr[3][2]=-1;
	        arr[3][1]=0;
	        
	        left.add(new Point(3,0,0));
	        right.add(new Point(3,2,0));
	        
	        for(int i=0;i<numbers.length;i++){
	           System.out.println(numbers[i]);
	            if(numbers[i]==1||numbers[i]==4||numbers[i]==7){
	                visited=new boolean[4][3];
	                Point l=bfs(numbers[i],left);
	                
	                left.clear();
	                left.add(new Point(l.x,l.y,0));
	                answer.append("L");
	            }
	            else if(numbers[i]==3||numbers[i]==6||numbers[i]==9){
	                visited=new boolean[4][3];
	                Point r=bfs(numbers[i],right);
	                
	                right.clear();
	                right.add(new Point(r.x,r.y,0));
	                answer.append("R");
	            }
	            else{
	                Point tmp_l=left.peek();
	                Point tmp_r=right.peek();
	                visited=new boolean[4][3];
	                Point l=bfs(numbers[i],left);
	                visited=new boolean[4][3];
	                Point r=bfs(numbers[i],right);
	                
	                if(l.cnt==r.cnt){
	                    if(hand.equals("right")){
	                        right.clear();
	                        right.add(new Point(r.x,r.y,0));
	                        answer.append("R");
	                        left.clear();
	                        left.add(tmp_l);
	                    }
	                    else{
	                        left.clear();
	                        left.add(new Point(l.x,l.y,0));
	                        answer.append("L");
	                        right.clear();
	                        right.add(tmp_r);
	                    }
	                }
	                else if(l.cnt>r.cnt){
	                    right.clear();
	                    right.add(new Point(r.x,r.y,0));
	                    answer.append("R");
	                    left.clear();
	                    left.add(tmp_l);
	                }
	                else if(l.cnt<r.cnt){
	                    left.clear();
	                    left.add(new Point(l.x,l.y,0));
	                    answer.append("L");
	                    right.clear();
	                    right.add(tmp_r);
	                }
	            }
	        }
	        return answer.toString();
	    }
	    
	    static Point bfs(int number,Queue<Point> q){
	        Point result=new Point(0,0,0);
	        
	        while(!q.isEmpty()){
	            Point now=q.poll();
	            visited[now.x][now.y]=true;
	            
	            if(arr[now.x][now.y]==number){
	                result=now;
	                break;
	            }
	            
	            for(int i=0;i<4;i++){
	                int nx=dx[i]+now.x;
	                int ny=dy[i]+now.y;
	                
	                if(nx<0||nx>=4||ny<0||ny>=3||visited[nx][ny]==true) continue;
	                q.add(new Point(nx,ny,now.cnt+1));
	                visited[nx][ny]=true;
	            }
	        }
	        return result;
	    }
	    
	}


