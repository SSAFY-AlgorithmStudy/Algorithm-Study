package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1043_거짓말 {

    public static void main(String ... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //사람의 수 N, 파티의 수 M
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;

        ArrayList<Integer>[] party = new ArrayList[M+1];
        int [] truePeople = new int [N+1];

        for(int i= 1; i<=M; i++){
            party[i] = new ArrayList<>();
        }

        //진실을 아는 사람
        st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());


        for(int i= 0; i<people; i++){
            int num = Integer.parseInt(st.nextToken());
            truePeople[num] = 1;
        }
        if(people == 0){
            System.out.println(M);
            return;
        }

        //파티의 수 만큼 있는 사람을 넣기
        for(int i= 1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j<num; j++){
                int k = Integer.parseInt(st.nextToken());
                party[i].add(k);
            }//end of for
        }//end of for
        boolean flag [] = new boolean [M+1];

        for(int p2 = 1; p2<=N; p2++) {
            for (int p = 1; p <= N; p++) {
                for (int i = 1; i <= M; i++) {
                    for (int j = 0; j < party[i].size(); j++) {
                        if (truePeople[p] == 1 && party[i].get(j) == p) {
                            flag[i] = true;
                        }
                    }//end of for

                    if (flag[i] == true) {
                        for (int j = 0; j < party[i].size(); j++) {
                            truePeople[party[i].get(j)] = 1;
                        }
                    }//end of for
                }
            }//end of for
        }


        for(int i= 1;i<=M; i++){
            if(flag[i] == false){
                result++;
            }
        }
        System.out.println(result);
        }//end of main

    }//end of class


