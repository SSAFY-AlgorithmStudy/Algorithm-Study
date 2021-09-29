package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {
    public static void main(String ... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int [][] Gear = new int [5][9];

        for(int i = 1; i<= 4; i++){
            String str = br.readLine();
            for(int j = 1; j<=8; j++){
                Gear[i][j] = str.charAt(j-1) -'0';
            }
        }
        int k = Integer.parseInt(br.readLine());
        int rotation [][] = new int [k+1][3];
        for(int i= 1; i<=k; i++){
            //회전시킨 톱니바퀴의 번호, 방향이 주어진다.
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=2; j++){
                rotation[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotate(Gear,rotation,k);
       int result = score(Gear);
       System.out.println(result);
       return;
    }

    private static int score(int[][] gear) {
        int result = 0;
        for(int i= 1 ; i<=2; i++){
            if(gear[i][1] == 1){
                result += i;
            }
        }//end of for
        for(int i= 3 ; i<=4; i++){
            if(gear[i][1] == 1 && i == 3){
                result += 4;
            }else if(gear[i][1] == 1 && i == 4){
                result += 8;
            }
        }//end of for
        return result;
    }//end of score method

    private static void rotate(int[][] gear, int[][] rotation, int k) {
        for(int i= 1; i<=k; i++){
           int rogear = rotation[i][1];
           int rodir = rotation[i][2];
           int [] change = new int [5];
           changeRogear(rogear, rodir, gear, change);
           realRotate(gear, change);

        }
    }//end of rotate method

    private static void realRotate(int[][] gear, int[] change) {
        for(int i= 1; i<=4; i++){
            if(change[i] == 1){
                clockwise(i,gear);
            }
            if(change[i] == -1){
                reclockwise(i,gear);
            }
        }
    }

    private static void reclockwise(int idx, int[][] gear) {
        int change [] = new int [9];
        for(int i = 1; i<=8; i++){
            if(i == 8){
                change[i] = gear[idx][1];
            }
            else {
                change[i] = gear[idx][i+1];
            }
        }
        for(int i = 1; i<=8; i++){
            gear[idx][i] = change[i];
        }
    }

    private static void clockwise(int idx, int[][] gear) {
        int change [] = new int [9];
        for(int i = 1; i<=8; i++){
            if(i == 1){
                change[i] = gear[idx][8];
            }
            else {
                change[i] = gear[idx][i-1];
            }
        }
        for(int i = 1; i<=8; i++){
            gear[idx][i] = change[i];
        }
    }

    private static void changeRogear(int rogear, int rodir, int[][] gear, int [] change) {
        int rerodir = 0;
        if(rodir == 1)
            rerodir = -1;
        else
            rerodir = 1;
        switch (rogear) {
            case 1:
                if (gear[1][3] == gear[2][7])
                    change[1] = rodir;
                else {
                    change[1] = rodir;
                    if(change[2] == 0) {
                        changeRogear(2, rerodir, gear, change);
                    }
                }
                break;
            case 2:
                if (gear[2][3] == gear[3][7]) {
                    change[2] = rodir;
                }
                else {
                    change[2] = rodir;
                    if(change[3] == 0)
                    changeRogear(3,rerodir, gear, change);
                }
                if (gear[2][7] == gear[1][3])
                    change[2] = rodir;
                else {
                    change[2] = rodir;
                    if(change[1] == 0)
                    changeRogear(1,rerodir, gear, change);
                }
                break;
            case 3:
                if (gear[3][3] == gear[4][7])
                    change[3] = rodir;
                else {
                    change[3] = rodir;
                    if(change[4] == 0)
                    changeRogear(4,rerodir, gear, change);
                }
                if (gear[3][7] == gear[2][3])
                    change[3] = rodir;
                else {
                    change[3] = rodir;
                    if(change[2] == 0)
                    changeRogear(2,rerodir, gear, change);
                }
                break;
            case 4:
                if (gear[4][7] == gear[3][3])
                    change[4] = rodir;
                else {
                    change[4] = rodir;
                    if(change[3] == 0)
                    changeRogear(3,rerodir, gear, change);
                }
                break;
        }//end of change switch
    }//end of changeRogear method
}//end of class
